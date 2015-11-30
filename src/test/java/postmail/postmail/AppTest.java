package postmail.postmail;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cvte.mail.HttpSender;
import com.cvte.mail.MailMessage;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        MailMessage mm=new MailMessage();
        
        mm.setFromAddress("some@some.com");
        List<String> to=new ArrayList<String>();
        to.add("wangpeng2383@cvte.com");
        to.add("wangpeng138375@126.com");
        mm.setToAddress(to);
        mm.setSubject("api test");
        mm.setContent("this is content");
        mm.setSys_id("123");
        Map<String, String> m=new HashMap<String, String>();
        m.put("a.txt", Base64.getEncoder().encodeToString("abc".getBytes()));
        mm.setAttachFileNames(m);
        HttpSender hs=HttpSender.getInstance();
        System.out.println(mm);
        hs.send(mm);
    }
}
