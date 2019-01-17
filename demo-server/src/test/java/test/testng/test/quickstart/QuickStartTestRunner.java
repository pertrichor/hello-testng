package test.testng.test.quickstart;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:启动测试
 *
 * @author XuTao
 * @create 2019-01-17 11:36
 */
public class QuickStartTestRunner {
    public static void main(String[] args) {
//        TestNG testNG = new TestNG();
//        testNG.setTestClasses(new Class[]{QuickStartTest.class});
//        testNG.run();

        XmlSuite suite = new XmlSuite();
        suite.setName("QuickStartTestSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("QuickStartTest");

        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass(QuickStartTest.class));
        test.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
