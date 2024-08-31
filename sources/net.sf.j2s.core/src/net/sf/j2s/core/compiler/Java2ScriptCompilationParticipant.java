package net.sf.j2s.core.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.core.compiler.ReconcileContext;

public class Java2ScriptCompilationParticipant extends CompilationParticipant {

	protected IContainer binaryFolder;

	private List<BuildContext> allFiles;
	
	@Override
	public int aboutToBuild(IJavaProject project) {
		if (allFiles == null) {
			allFiles = new ArrayList<>();
		} else {
			allFiles.clear();
		}
		return READY_FOR_BUILD;
	}

	@Override
	public void buildFinished(IJavaProject project) {
        try {
            IPath outputLocation = project.getOutputLocation();
            IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
            binaryFolder = workspaceRoot.getFolder(outputLocation);
            //System.out.println("Binary Location: " + binaryFolder.getLocation().toOSString());
            
            int size = allFiles.size();
            for (int i = 0; i < size; i++) {
				BuildContext buildContext = allFiles.get(i);
	            IFile file = buildContext.getFile();
				Java2ScriptCompiler.process(file, binaryFolder);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }		// TODO Auto-generated method stub
		super.buildFinished(project);
	}

	@Override
	public void buildStarting(BuildContext[] files, boolean isBatch) {
		for (int i = 0; i < files.length; i++) {
			allFiles.add(files[i]);
		}
	}

	@Override
	public void cleanStarting(IJavaProject project) {
		allFiles.clear();
		super.cleanStarting(project);
	}

	@Override
	public boolean isActive(IJavaProject project) {
		IPath path = project.getProject().getLocation();
		String prjFolder = path.toOSString();
		File file = new File(prjFolder, ".j2s"); //$NON-NLS-1$
		if (!file.exists()) {
			/*
			 * The file .j2s is a marker for Java2Script to compile JavaScript
			 */
			return false;
		}
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(file));
			String status = props.getProperty("j2s.compiler.status");
			if (!"enable".equals(status)) {
				/*
				 * Not enabled!
				 */
				return false;
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean isAnnotationProcessor() {
		return super.isAnnotationProcessor();
	}

	@Override
	public void processAnnotations(BuildContext[] files) {
		super.processAnnotations(files);
	}

	@Override
	public void reconcile(ReconcileContext context) {
		super.reconcile(context);
	}

}
