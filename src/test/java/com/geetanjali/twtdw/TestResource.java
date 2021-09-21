package com.geetanjali.twtdw;
import com.geetanjali.twtdw.resources.Resource;
import org.easymock.EasyMock;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.TwitterException;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(EasyMockRunner.class)
public class TestResource {

    @TestSubject
    Resource resource = new Resource("Demo");

    @Mock
    RetrieveTweets twt;

    /*public static void main(String[] args) throws IOException, TwitterException {
        TestResource tester = new TestResource();
        //tester.setUp();
        System.out.println(tester.testRetrieval()?"Pass":"Fail");
    }*/

    /*public void setUp()
    {
        twt = EasyMock.createMock(RetrieveTweets.class);
        resource.setTWT(twt);
    }*/

    @Test
    public void testRetrieval() throws TwitterException, IOException
    {
            Response r;
            Paging page = new Paging(1, 200);
            List<Status> newlist = new ArrayList<Status>();
            EasyMock.expect(twt.getStatus(page)).andReturn(newlist);
            EasyMock.replay(twt);
            r = resource.fetchTweet();

            Assert.assertNotNull(r.getEntity());
    }
}
