package sample.mybatis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleMybatisApplication.class)
public class SampleMybatisApplicationTest extends SampleMybatisApplication {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @ClassRule
    public static OutputCapture out = new OutputCapture();

    @Test
    public void test() {
        //fail("Not yet implemented");
        String output = this.out.toString();
        assertTrue("Wrong output: " + output, output.contains("SAN FRANCISCO"));
    }

}
