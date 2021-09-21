package com.geetanjali.twtdw;

import twitter4j.Paging;
import twitter4j.Status;

import java.util.List;

public interface RetrieveTweets
{
    public List<Status> getStatus(Paging page);
}
