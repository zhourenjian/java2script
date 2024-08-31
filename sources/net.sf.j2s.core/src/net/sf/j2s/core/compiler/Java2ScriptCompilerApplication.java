package net.sf.j2s.core.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class Java2ScriptCompilerApplication implements IApplication {

    @Override
    public Object start(IApplicationContext context) throws Exception {
    	ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IWorkspaceRoot.DEPTH_INFINITE, null);
    	System.out.println("Java2Script compiler application starting...");
        IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

        for (IProject project : projects) {
            if (project.isOpen() && project.hasNature(JavaCore.NATURE_ID)) {
        		IPath path = project.getLocation();
        		String prjFolder = path.toOSString();
        		File file = new File(prjFolder, ".j2s"); //$NON-NLS-1$
        		if (!file.exists()) {
        			/*
        			 * The file .j2s is a marker for Java2Script to compile JavaScript
        			 */
        			continue;
        		}
        		Properties props = new Properties();
        		try {
        			props.load(new FileInputStream(file));
        			String status = props.getProperty("j2s.compiler.status");
        			if (!"enable".equals(status)) {
        				/*
        				 * Not enabled!
        				 */
        				continue;
        			}
        		} catch (FileNotFoundException e1) {
        			e1.printStackTrace();
        		} catch (IOException e1) {
        			e1.printStackTrace();
        		}

            	System.out.println("To compile project " + project);

        		project.touch(null);
        		project.refreshLocal(IResource.DEPTH_INFINITE, null);
//        		project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);			
        		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
//                IJavaProject javaProject = JavaCore.create(project);
//                compileJavaProject(javaProject);
            }
        }
        
        return IApplication.EXIT_OK;
    }

    @Override
    public void stop() {
    }

	/*
    private void compileJavaProject(IJavaProject javaProject) throws Exception {
        IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
        for (IPackageFragmentRoot root : roots) {
            if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
        	    IJavaElement[] packages = root.getChildren();
        	    for (IJavaElement pkg : packages) {
        	        if (pkg instanceof IPackageFragment) {
        	            IPackageFragment packageFragment = (IPackageFragment) pkg;
        	            ICompilationUnit[] units = packageFragment.getCompilationUnits();
        	            for (ICompilationUnit unit : units) {
        	            	System.out.println("To compile unit " + unit);
        	            	
        	                unit.becomeWorkingCopy(null);
        	                unit.reconcile(ICompilationUnit.NO_AST, false, null, null);
        	                //unit.reconcile(ICompilationUnit.FORCE_PROBLEM_DETECTION, true, null, null);
//        	                ASTParser parser = ASTParser.newParser(AST.JLS_Latest);
//        	                parser.setSource(unit);
//        	                CompilationUnit ast = (CompilationUnit) parser.createAST(null);
        	                unit.commitWorkingCopy(false, null);
        	                unit.discardWorkingCopy();
        	            }
        	        }
        	    }
            }
        }
    }
    //*/
}
