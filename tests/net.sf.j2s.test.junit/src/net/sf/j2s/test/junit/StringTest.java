/* Copyright 1998, 2005 The Apache Software Foundation or its licensors, as applicable
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sf.j2s.test.junit;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class StringTest extends junit.framework.TestCase {

	String hw1 = "HelloWorld";

	String hw2 = "HelloWorld";

	String hwlc = "helloworld";

	String hwuc = "HELLOWORLD";

	String hello1 = "Hello";

	String world1 = "World";

	String comp11 = "Test String";

	Object obj = new Object();

	char[] buf = { 'W', 'o', 'r', 'l', 'd' };

	char[] rbuf = new char[5];

	/**
	 * @tests java.lang.String#String()
	 */
	public void test_Constructor() {
		// Test for method java.lang.String()
		assertTrue("Created incorrect string", new String().equals(""));
	}

	/**
	 * @tests java.lang.String#String(byte[])
	 */
	public void test_Constructor$B() {
		// Test for method java.lang.String(byte [])
		assertTrue("Failed to create string", new String(hw1.getBytes())
				.equals(hw1));
	}

	/**
	 * @tests java.lang.String#String(byte[], int)
	 */
	public void test_Constructor$BI() {
		// Test for method java.lang.String(byte [], int)
		String s = new String(new byte[] { 65, 66, 67, 68, 69 }, 0);
		assertTrue("Incorrect string returned: " + s, s.equals("ABCDE"));
		s = new String(new byte[] { 65, 66, 67, 68, 69 }, 1);
		assertTrue("Did not use nonzero hibyte", !s.equals("ABCDE"));
	}

	/**
	 * @tests java.lang.String#String(byte[], int, int)
	 */
	public void test_Constructor$BII() {
		// Test for method java.lang.String(byte [], int, int)
		assertTrue("Failed to create string", new String(hw1.getBytes(), 0, hw1
				.getBytes().length).equals(hw1));

		boolean exception = false;
		try {
			new String(new byte[0], 0, Integer.MAX_VALUE);
		} catch (IndexOutOfBoundsException e) {
			exception = true;
		}
		assertTrue("Did not throw exception", exception);
	}

	/**
	 * @tests java.lang.String#String(byte[], int, int, int)
	 */
	public void test_Constructor$BIII() {
		// Test for method java.lang.String(byte [], int, int, int)
		String s = new String(new byte[] { 65, 66, 67, 68, 69 }, 0, 1, 3);
		assertTrue("Incorrect string returned: " + s, s.equals("BCD"));
		s = new String(new byte[] { 65, 66, 67, 68, 69 }, 1, 0, 5);
		assertTrue("Did not use nonzero hibyte", !s.equals("ABCDE"));
	}

	/**
	 * @tests java.lang.String#String(byte[], int, int, java.lang.String)
	 */
	public void test_Constructor$BIILjava_lang_String() {
		// Test for method java.lang.String(byte [], int, int, java.lang.String)
		String s = null;
		try {
			s = new String(new byte[] { 65, 66, 67, 68, 69 }, 0, 5, "8859_1");
		} catch (Exception e) {
			fail("Threw exception : " + e.getMessage());
		}
		assertTrue("Incorrect string returned: " + s, s.equals("ABCDE"));
	}

	/**
	 * @tests java.lang.String#String(byte[], java.lang.String)
	 */
	public void test_Constructor$BLjava_lang_String() {
		// Test for method java.lang.String(byte [], java.lang.String)
		String s = null;
		try {
			s = new String(new byte[] { 65, 66, 67, 68, 69 }, "8859_1");
		} catch (Exception e) {
			fail("Threw exception : " + e.getMessage());
		}
		assertTrue("Incorrect string returned: " + s, s.equals("ABCDE"));
	}

	/**
	 * @tests java.lang.String#String(char[])
	 */
	public void test_Constructor$C() {
		// Test for method java.lang.String(char [])
		assertEquals("Failed Constructor test", "World", new String(buf));
	}

	/**
	 * @tests java.lang.String#String(char[], int, int)
	 */
	public void test_Constructor$CII() {
		// Test for method java.lang.String(char [], int, int)
		char[] buf = { 'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd' };
		String s = new String(buf, 0, buf.length);
		assertTrue("Incorrect string created", hw1.equals(s));

		boolean exception = false;
		try {
			new String(new char[0], 0, Integer.MAX_VALUE);
		} catch (IndexOutOfBoundsException e) {
			exception = true;
		}
		assertTrue("Did not throw exception", exception);
	}

	/**
	 * @tests java.lang.String#String(int[], int, int)
	 */
	public void test_Constructor$III() {
		// Test for method java.lang.String(int [], int, int)
		try {
			new String(new int[0], 2, Integer.MAX_VALUE);
			fail("Did not throw exception");
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}

	/**
	 * @tests java.lang.String#String(java.lang.String)
	 */
	public void test_ConstructorLjava_lang_String() {
		// Test for method java.lang.String(java.lang.String)
		String s = new String("Hello World");
		assertEquals("Failed to construct correct string", "Hello World", s
				);
	}

	/**
	 * @tests java.lang.String#String(java.lang.StringBuffer)
	 */
	public void test_ConstructorLjava_lang_StringBuffer() {
		// Test for method java.lang.String(java.lang.StringBuffer)
		StringBuffer sb = new StringBuffer();
		sb.append("HelloWorld");
		assertEquals("Created incorrect string", "HelloWorld", new String(sb)
				);
	}

	/**
	 * @tests java.lang.String#charAt(int)
	 */
	public void test_charAtI() {
		// Test for method char java.lang.String.charAt(int)
		assertTrue("Incorrect character returned", hw1.charAt(5) == 'W'
				&& (hw1.charAt(1) != 'Z'));
	}

	/**
	 * @tests java.lang.String#compareTo(java.lang.String)
	 */
	public void test_compareToLjava_lang_String() {
		// Test for method int java.lang.String.compareTo(java.lang.String)
		assertTrue("Returned incorrect value for first < second", "aaaaab"
				.compareTo("aaaaac") < 0);
		assertEquals("Returned incorrect value for first = second", 0, "aaaaac"
				.compareTo("aaaaac"));
		assertTrue("Returned incorrect value for first > second", "aaaaac"
				.compareTo("aaaaab") > 0);
		assertTrue("Considered case to not be of importance", !("A"
				.compareTo("a") == 0));
        
        try {
            "fixture".compareTo(null);
            fail("No NPE");
        } catch (NullPointerException e) {
        }
	}

	/**
	 * @tests java.lang.String#compareToIgnoreCase(java.lang.String)
	 */
	public void test_compareToIgnoreCaseLjava_lang_String() {
		// Test for method int
		// java.lang.String.compareToIgnoreCase(java.lang.String)
		assertTrue("Returned incorrect value for first < second", "aaaaab"
				.compareToIgnoreCase("aaaaac") < 0);
		assertEquals("Returned incorrect value for first = second", 0, "aaaaac"
				.compareToIgnoreCase("aaaaac"));
		assertTrue("Returned incorrect value for first > second", "aaaaac"
				.compareToIgnoreCase("aaaaab") > 0);
		assertEquals("Considered case to not be of importance", 0, "A"
				.compareToIgnoreCase("a"));

		assertTrue("0xbf should not compare = to 'ss'", "\u00df"
				.compareToIgnoreCase("ss") != 0);
		assertEquals("0x130 should compare = to 'i'", 0, "\u0130"
				.compareToIgnoreCase("i"));
		assertEquals("0x131 should compare = to 'i'", 0, "\u0131"
				.compareToIgnoreCase("i"));

		Locale defLocale = Locale.getDefault();
		try {
			Locale.setDefault(new Locale("tr", ""));
			assertEquals("Locale tr: 0x130 should compare = to 'i'", 0, "\u0130"
					.compareToIgnoreCase("i"));
			assertEquals("Locale tr: 0x131 should compare = to 'i'", 0, "\u0131"
					.compareToIgnoreCase("i"));
		} finally {
			Locale.setDefault(defLocale);
		}
        
        try {
            "fixture".compareToIgnoreCase(null);
            fail("No NPE");
        } catch (NullPointerException e) {
        }
	}

	/**
	 * @tests java.lang.String#concat(java.lang.String)
	 */
	public void test_concatLjava_lang_String() {
		// Test for method java.lang.String
		// java.lang.String.concat(java.lang.String)
		assertTrue("Concatenation failed to produce correct string", hello1
				.concat(world1).equals(hw1));
		boolean exception = false;
		try {
			String a = new String("test");
			String b = null;
			a.concat(b);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue("Concatenation failed to throw NP exception (1)", exception);
		exception = false;
		try {
			String a = new String("");
			String b = null;
			a.concat(b);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue("Concatenation failed to throw NP exception (2)", exception);

		String s1 = "";
		String s2 = "s2";
		String s3 = s1.concat(s2);
		assertEquals(s2, s3);
        
        s3 = s2.concat(s1);
        assertSame(s2, s3);
	}

	/**
	 * @tests java.lang.String#copyValueOf(char[])
	 */
	public void test_copyValueOf$C() {
		// Test for method java.lang.String java.lang.String.copyValueOf(char
		// [])
		char[] t = { 'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd' };
		assertEquals("copyValueOf returned incorrect String", "HelloWorld", String.copyValueOf(
				t));
	}

	/**
	 * @tests java.lang.String#copyValueOf(char[], int, int)
	 */
	public void test_copyValueOf$CII() {
		// Test for method java.lang.String java.lang.String.copyValueOf(char
		// [], int, int)
		char[] t = { 'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd' };
		assertEquals("copyValueOf returned incorrect String", "World", String.copyValueOf(
				t, 5, 5));
	}

	/**
	 * @tests java.lang.String#endsWith(java.lang.String)
	 */
	public void test_endsWithLjava_lang_String() {
		// Test for method boolean java.lang.String.endsWith(java.lang.String)
		assertTrue("Failed to fine ending string", hw1.endsWith("ld"));
	}

	/**
	 * @tests java.lang.String#equals(java.lang.Object)
	 */
	public void test_equalsLjava_lang_Object() {
		// Test for method boolean java.lang.String.equals(java.lang.Object)
		assertTrue("String not equal", hw1.equals(hw2) && !(hw1.equals(comp11)));
	}

	/**
	 * @tests java.lang.String#equalsIgnoreCase(java.lang.String)
	 */
	public void test_equalsIgnoreCaseLjava_lang_String() {
		// Test for method boolean
		// java.lang.String.equalsIgnoreCase(java.lang.String)
		assertTrue("lc version returned unequal to uc", hwlc
				.equalsIgnoreCase(hwuc));
	}

	/**
	 * @tests java.lang.String#getBytes()
	 * @j2sIgnore
	 */
	public void test_getBytes() {
		// Test for method byte [] java.lang.String.getBytes()
		byte[] sbytes = hw1.getBytes();
		for (int i = 0; i < hw1.length(); i++)
			assertTrue("Returned incorrect bytes", sbytes[i] == (byte) hw1
					.charAt(i));

		char[] chars = new char[1];
		for (int i = 0; i < 65536; i++) {
			// skip surrogates
			if (i == 0xd800)
				i = 0xe000;
			byte[] result = null;
			chars[0] = (char) i;
			String string = new String(chars);
			try {
				result = string.getBytes("8859_1");
                if (i < 256) {
                    assertEquals((byte)i, result[0]);
                } else {
                    /*
                     * Substitue character should be 0x1A [1], but may be
                     * '?' character.
                     * [1] http://en.wikipedia.org/wiki/Substitute_character
                     */
                    assertTrue(result[0] == '?' || result[0] == 0x1a);
                }
			} catch (java.io.UnsupportedEncodingException e) {
			}
			try {
				result = string.getBytes("UTF8");
				int length = i < 0x80 ? 1 : (i < 0x800 ? 2 : 3);
				assertTrue("Wrong length UTF8: " + Integer.toHexString(i),
						result.length == length);
				assertTrue(
						"Wrong bytes UTF8: " + Integer.toHexString(i),
						(i < 0x80 && result[0] == i)
								|| (i >= 0x80
										&& i < 0x800
										&& result[0] == (byte) (0xc0 | ((i & 0x7c0) >> 6)) && result[1] == (byte) (0x80 | (i & 0x3f)))
								|| (i >= 0x800
										&& result[0] == (byte) (0xe0 | (i >> 12))
										&& result[1] == (byte) (0x80 | ((i & 0xfc0) >> 6)) && result[2] == (byte) (0x80 | (i & 0x3f))));
			} catch (java.io.UnsupportedEncodingException e) {
			}

			String bytes = null;
			try {
				bytes = new String(result, "UTF8");
				assertTrue("Wrong UTF8 byte length: " + bytes.length() + "("
						+ i + ")", bytes.length() == 1);
				assertTrue(
						"Wrong char UTF8: "
								+ Integer.toHexString(bytes.charAt(0)) + " ("
								+ i + ")", bytes.charAt(0) == i);
			} catch (java.io.UnsupportedEncodingException e) {
			}
		}

		byte[] bytes = new byte[1];
		for (int i = 0; i < 256; i++) {
			bytes[0] = (byte) i;
			String result = null;
			try {
				result = new String(bytes, "8859_1");
				assertEquals("Wrong char length", 1, result.length());
				assertTrue("Wrong char value", result.charAt(0) == (char) i);
			} catch (java.io.UnsupportedEncodingException e) {
			}
		}
	}

	/**
	 * @tests java.lang.String#getBytes(int, int, byte[], int)
	 */
	public void test_getBytesII$BI() {
		// Test for method void java.lang.String.getBytes(int, int, byte [],
		// int)
		byte[] buf = new byte[5];
		"Hello World".getBytes(6, 11, buf, 0);
		assertEquals("Returned incorrect bytes", "World", new String(buf));

		Exception exception = null;
		try {
			"Hello World".getBytes(-1, 1, null, 0);
			fail("Expected StringIndexOutOfBoundsException");
		} catch (StringIndexOutOfBoundsException e) {
		} catch (NullPointerException e) {
			fail("Threw wrong exception");
		}
	}

	/**
	 * @tests java.lang.String#getBytes(java.lang.String)
	 */
	public void test_getBytesLjava_lang_String() throws Exception {
        // Test for method byte [] java.lang.String.getBytes(java.lang.String)
        byte[] buf = "Hello World".getBytes();
        assertEquals("Returned incorrect bytes", "Hello World", new String(buf));

        try {
            "string".getBytes("8849_1");
            fail("No UnsupportedEncodingException");
        } catch (UnsupportedEncodingException e) {
        }

        byte[] bytes = "\u3048".getBytes("UTF-8");
        byte[] expected = new byte[] {(byte)0xE3, (byte)0x81, (byte)0x88};
        assertEquals(expected[0], bytes[0]);
        assertEquals(expected[1], bytes[1]);
        assertEquals(expected[2], bytes[2]);

        // Regression for HARMONY-663
        try {
            "string".getBytes("?Q?D??_??_6ffa?+vG?_??�???");
            fail("No UnsupportedEncodingException");
        } catch (UnsupportedEncodingException e) {
            //expected
        }
    }

	/**
	 * @tests java.lang.String#getChars(int, int, char[], int)
	 */
	public void test_getCharsII$CI() {
		// Test for method void java.lang.String.getChars(int, int, char [],
		// int)
		hw1.getChars(5, hw1.length(), rbuf, 0);

		for (int i = 0; i < rbuf.length; i++)
			assertTrue("getChars returned incorrect char(s)", rbuf[i] == buf[i]);
	}

	/**
	 * @tests java.lang.String#hashCode()
	 */
	public void test_hashCode() {
		// Test for method int java.lang.String.hashCode()
		int hwHashCode = 0;
		final int hwLength = hw1.length();
		int powerOfThirtyOne = 1;
		for (int counter = hwLength - 1; counter >= 0; counter--) {
			hwHashCode += ((int) hw1.charAt(counter)) * powerOfThirtyOne;
			hwHashCode &= 0xffffffff;
			powerOfThirtyOne *= 31;
		}
		assertTrue("String did not hash to correct value--got: "
				+ String.valueOf(hw1.hashCode()) + " but wanted: "
				+ String.valueOf(hwHashCode), hw1.hashCode() == hwHashCode);
		assertTrue("The empty string \"\" did not hash to zero", 0 == ""
				.hashCode());
	}

	/**
	 * @tests java.lang.String#indexOf(int)
	 */
	public void test_indexOfI() {
		// Test for method int java.lang.String.indexOf(int)
		assertEquals("Invalid index returned", 1, hw1.indexOf('e'));

	}

	/**
	 * @tests java.lang.String#indexOf(int, int)
	 */
	public void test_indexOfII() {
		// Test for method int java.lang.String.indexOf(int, int)
		assertEquals("Invalid character index returned", 5, hw1.indexOf('W', 2));

	}

	/**
	 * @tests java.lang.String#indexOf(java.lang.String)
	 */
	public void test_indexOfLjava_lang_String() {
		// Test for method int java.lang.String.indexOf(java.lang.String)
		assertTrue("Failed to find string", hw1.indexOf("World") > 0);
		assertTrue("Failed to find string", !(hw1.indexOf("ZZ") > 0));
	}

	/**
	 * @tests java.lang.String#indexOf(java.lang.String, int)
	 */
	public void test_indexOfLjava_lang_StringI() {
		// Test for method int java.lang.String.indexOf(java.lang.String, int)
		assertTrue("Failed to find string", hw1.indexOf("World", 0) > 0);
		assertTrue("Found string outside index", !(hw1.indexOf("Hello", 6) > 0));
		assertEquals("Did not accept valid negative starting position", 0, hello1
				.indexOf("", -5));
		assertEquals("Reported wrong error code", 5, hello1.indexOf("", 5));
		assertEquals("Wrong for empty in empty", 0, "".indexOf("", 0));
	}

	/**
	 * @tests java.lang.String#intern()
	 */
	public void test_intern() {
		// Test for method java.lang.String java.lang.String.intern()
		assertTrue("Intern returned incorrect result", hw1.intern() == hw2
				.intern());
	}

	/**
	 * @tests java.lang.String#lastIndexOf(int)
	 */
	public void test_lastIndexOfI() {
		// Test for method int java.lang.String.lastIndexOf(int)
		assertEquals("Failed to return correct index", 5, hw1.lastIndexOf('W'));
		assertEquals("Returned index for non-existent char",
				-1, hw1.lastIndexOf('Z'));

	}

	/**
	 * @tests java.lang.String#lastIndexOf(int, int)
	 */
	public void test_lastIndexOfII() {
		// Test for method int java.lang.String.lastIndexOf(int, int)
		assertEquals("Failed to return correct index",
				5, hw1.lastIndexOf('W', 6));
		assertEquals("Returned index for char out of specified range", -1, hw1
				.lastIndexOf('W', 4));
		assertEquals("Returned index for non-existent char", -1, hw1.lastIndexOf('Z',
				9));

	}

	/**
	 * @tests java.lang.String#lastIndexOf(java.lang.String)
	 */
	public void test_lastIndexOfLjava_lang_String() {
		// Test for method int java.lang.String.lastIndexOf(java.lang.String)
		assertEquals("Returned incorrect index", 5, hw1.lastIndexOf("World"));
		assertEquals("Found String outside of index", -1, hw1
				.lastIndexOf("HeKKKKKKKK"));
	}

	/**
	 * @tests java.lang.String#lastIndexOf(java.lang.String, int)
	 */
	public void test_lastIndexOfLjava_lang_StringI() {
		// Test for method int java.lang.String.lastIndexOf(java.lang.String,
		// int)
		assertEquals("Returned incorrect index", 5, hw1.lastIndexOf("World", 9));
		int result = hw1.lastIndexOf("Hello", 2);
		assertTrue("Found String outside of index: " + result, result == 0);
		assertEquals("Reported wrong error code",
				-1, hello1.lastIndexOf("", -5));
		assertEquals("Did not accept valid large starting position", 5, hello1
				.lastIndexOf("", 5));
	}

	/**
	 * @tests java.lang.String#length()
	 */
	public void test_length() {
		// Test for method int java.lang.String.length()
		assertEquals("Invalid length returned", 11, comp11.length());
	}

	/**
	 * @tests java.lang.String#regionMatches(int, java.lang.String, int, int)
	 */
	public void test_regionMatchesILjava_lang_StringII() {
		// Test for method boolean java.lang.String.regionMatches(int,
		// java.lang.String, int, int)
		String bogusString = "xxcedkedkleiorem lvvwr e''' 3r3r 23r";

		assertTrue("identical regions failed comparison", hw1.regionMatches(2,
				hw2, 2, 5));
		assertTrue("Different regions returned true", !hw1.regionMatches(2,
				bogusString, 2, 5));
	}

	/**
	 * @tests java.lang.String#regionMatches(boolean, int, java.lang.String,
	 *        int, int)
	 */
	public void test_regionMatchesZILjava_lang_StringII() {
		// Test for method boolean java.lang.String.regionMatches(boolean, int,
		// java.lang.String, int, int)

		String bogusString = "xxcedkedkleiorem lvvwr e''' 3r3r 23r";

		assertTrue("identical regions failed comparison", hw1.regionMatches(
				false, 2, hw2, 2, 5));
		assertTrue("identical regions failed comparison with different cases",
				hw1.regionMatches(true, 2, hw2, 2, 5));
		assertTrue("Different regions returned true", !hw1.regionMatches(true,
				2, bogusString, 2, 5));
		assertTrue("identical regions failed comparison with different cases",
				hw1.regionMatches(false, 2, hw2, 2, 5));
	}

	/**
	 * @tests java.lang.String#replace(char, char)
	 */
	public void test_replaceCC() {
		// Test for method java.lang.String java.lang.String.replace(char, char)
		assertEquals("Failed replace", "HezzoWorzd", hw1.replace('l', 'z'));
	}

	/**
	 * @tests java.lang.String#startsWith(java.lang.String)
	 */
	public void test_startsWithLjava_lang_String() {
		// Test for method boolean java.lang.String.startsWith(java.lang.String)
		assertTrue("Failed to find string", hw1.startsWith("Hello"));
		assertTrue("Found incorrect string", !hw1.startsWith("T"));
	}

	/**
	 * @tests java.lang.String#startsWith(java.lang.String, int)
	 */
	public void test_startsWithLjava_lang_StringI() {
		// Test for method boolean java.lang.String.startsWith(java.lang.String,
		// int)
		assertTrue("Failed to find string", hw1.startsWith("World", 5));
		assertTrue("Found incorrect string", !hw1.startsWith("Hello", 5));
	}

	/**
	 * @tests java.lang.String#substring(int)
	 */
	public void test_substringI() {
		// Test for method java.lang.String java.lang.String.substring(int)
		assertEquals("Incorrect substring returned", 
				"World", hw1.substring(5));
		assertTrue("not identical", hw1.substring(0) == hw1);
	}

	/**
	 * @tests java.lang.String#substring(int, int)
	 */
	public void test_substringII() {
		// Test for method java.lang.String java.lang.String.substring(int, int)
		assertTrue("Incorrect substring returned", hw1.substring(0, 5).equals(
				"Hello")
				&& (hw1.substring(5, 10).equals("World")));
		assertTrue("not identical", hw1.substring(0, hw1.length()) == hw1);
	}

	/**
	 * @tests java.lang.String#toCharArray()
	 */
	public void test_toCharArray() {
		// Test for method char [] java.lang.String.toCharArray()

		String s = new String(buf, 0, buf.length);
		char[] schars = s.toCharArray();
		for (int i = 0; i < s.length(); i++)
			assertTrue("Returned incorrect char aray", buf[i] == schars[i]);
	}

	/**
	 * @tests java.lang.String#toLowerCase()
	 */
	public void test_toLowerCase() {
		// Test for method java.lang.String java.lang.String.toLowerCase()
		assertTrue("toLowerCase case conversion did not succeed", hwuc
				.toLowerCase().equals(hwlc));

		assertEquals("a) Sigma has same lower case value at end of word with Unicode 3.0",
				"\u03c3", "\u03a3".toLowerCase());
		assertEquals("b) Sigma has same lower case value at end of word with Unicode 3.0",
				"a \u03c3", "a \u03a3".toLowerCase());
	}

	/**
	 * @tests java.lang.String#toLowerCase(java.util.Locale)
	 */
	public void test_toLowerCaseLjava_util_Locale() {
		// Test for method java.lang.String
		// java.lang.String.toLowerCase(java.util.Locale)
		assertTrue("toLowerCase case conversion did not succeed", hwuc
				.toLowerCase(java.util.Locale.getDefault()).equals(hwlc));
		assertEquals("Invalid \\u0049 for English", "\u0069", "\u0049".toLowerCase(
				Locale.ENGLISH));
		assertEquals("Invalid \\u0049 for Turkish", "\u0131", "\u0049".toLowerCase(
				new Locale("tr", "")));
	}

	private static String writeString(String in) {
		StringBuffer result = new StringBuffer();
		result.append("\"");
		for (int i = 0; i < in.length(); i++) {
			result.append(" 0x" + Integer.toHexString(in.charAt(i)));
		}
		result.append("\"");
		return result.toString();
	}

	/**
	 * @tests java.lang.String#toLowerCase(java.util.Locale)
	 */
	public void test_toLowerCaseLjava_util_Locale_subtest0() {
		// Test for method java.lang.String
		// java.lang.String.toLowerCase(java.util.Locale)
	}

	/**
	 * @tests java.lang.String#toString()
	 */
	public void test_toString() {
		// Test for method java.lang.String java.lang.String.toString()
		assertTrue("Incorrect string returned", hw1.toString().equals(hw1));
	}

	/**
	 * @tests java.lang.String#toUpperCase()
	 */
	public void test_toUpperCase() {
		// Test for method java.lang.String java.lang.String.toUpperCase()
		assertTrue("Returned string is not UpperCase", hwlc.toUpperCase()
				.equals(hwuc));

		//assertEquals("Wrong conversion", "SS", "\u00df".toUpperCase());

		String s = "a\u00df\u1f56";
		assertTrue("Invalid conversion", !s.toUpperCase().equals(s));

	}

	/**
	 * @tests java.lang.String#toUpperCase(java.util.Locale)
	 */
	public void test_toUpperCaseLjava_util_Locale() {
		// Test for method java.lang.String
		// java.lang.String.toUpperCase(java.util.Locale)
		assertTrue("Returned string is not UpperCase", hwlc.toUpperCase()
				.equals(hwuc));
		assertEquals("Invalid \\u0069 for English", "\u0049", "\u0069".toUpperCase(
				Locale.ENGLISH));
		assertEquals("Invalid \\u0069 for Turkish", "\u0130", "\u0069".toUpperCase(
				new Locale("tr", "")));
	}

	/**
	 * @tests java.lang.String#toUpperCase(java.util.Locale)
	 */
	public void test_toUpperCaseLjava_util_Locale_subtest0() {
		// Test for method java.lang.String
		// java.lang.String.toUpperCase(java.util.Locale)
	}

	/**
	 * @tests java.lang.String#trim()
	 */
	public void test_trim() {
		// Test for method java.lang.String java.lang.String.trim()
		assertTrue("Incorrect string returned", " HelloWorld ".trim().equals(
				hw1));
	}

	/**
	 * @tests java.lang.String#valueOf(char[])
	 */
	public void test_valueOf$C() {
		// Test for method java.lang.String java.lang.String.valueOf(char [])
		assertEquals("Returned incorrect String", 
				"World", String.valueOf(buf));
	}

	/**
	 * @tests java.lang.String#valueOf(char[], int, int)
	 */
	public void test_valueOf$CII() {
		// Test for method java.lang.String java.lang.String.valueOf(char [],
		// int, int)
		char[] t = { 'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd' };
		assertEquals("copyValueOf returned incorrect String", "World", String.valueOf(t,
				5, 5));
	}

	/**
	 * @tests java.lang.String#valueOf(char)
	 * @j2sIgnore
	 */
	public void test_valueOfC() {
		// Test for method java.lang.String java.lang.String.valueOf(char)
		for (int i = 0; i < 65536; i++)
			assertTrue("Incorrect valueOf(char) returned: " + i, String
					.valueOf((char) i).charAt(0) == (char) i);
	}

	/**
	 * @tests java.lang.String#valueOf(double)
	 */
	public void test_valueOfD() {
		// Test for method java.lang.String java.lang.String.valueOf(double)
		assertEquals("Incorrect double string returned", "1.7976931348623157E308", String.valueOf(
				Double.MAX_VALUE));
	}

	/**
	 * @tests java.lang.String#valueOf(float)
	 */
	public void test_valueOfF() {
		// Test for method java.lang.String java.lang.String.valueOf(float)
		assertTrue("incorrect float string returned--got: "
				+ String.valueOf(1.0F) + " wanted: 1.0", String.valueOf(1.0F)
				.equals("1.0"));
		assertTrue("incorrect float string returned--got: "
				+ String.valueOf(0.9F) + " wanted: 0.9", String.valueOf(0.9F)
				.equals("0.9"));
		assertTrue("incorrect float string returned--got: "
				+ String.valueOf(109.567F) + " wanted: 109.567", String
				.valueOf(109.567F).equals("109.567"));
	}

	/**
	 * @tests java.lang.String#valueOf(int)
	 */
	public void test_valueOfI() {
		// Test for method java.lang.String java.lang.String.valueOf(int)
		assertEquals("returned invalid int string", "1", String.valueOf(1));
	}

	/**
	 * @tests java.lang.String#valueOf(long)
	 */
	public void test_valueOfJ() {
		// Test for method java.lang.String java.lang.String.valueOf(long)
		assertEquals("returned incorrect long string", "927654321098", String.valueOf(
				927654321098L));
	}

	/**
	 * @tests java.lang.String#valueOf(java.lang.Object)
	 */
	public void test_valueOfLjava_lang_Object() {
		// Test for method java.lang.String
		// java.lang.String.valueOf(java.lang.Object)
		assertTrue("Incorrect Object string returned", obj.toString().equals(
				String.valueOf(obj)));
	}

	/**
	 * @tests java.lang.String#valueOf(boolean)
	 */
	public void test_valueOfZ() {
		// Test for method java.lang.String java.lang.String.valueOf(boolean)
		assertTrue("Incorrect boolean string returned", String.valueOf(false)
				.equals("false")
				&& (String.valueOf(true).equals("true")));
	}

	/**
	 * Sets up the fixture, for example, open a network connection. This method
	 * is called before a test is executed.
	 */
	protected void setUp() {
	}

	/**
	 * Tears down the fixture, for example, close a network connection. This
	 * method is called after a test is executed.
	 */
	protected void tearDown() {
	}

	protected void doneSuite() {
	}
}
