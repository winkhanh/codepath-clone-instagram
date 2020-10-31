package com.winkhanh.clone_instagram.fragments;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.winkhanh.clone_instagram.Post;

import java.util.List;

public class ProfileFragment extends PostFragment{
    public static final String TAG="ProfileFragment";
    @Override
    protected void queryPost() {
        ParseQuery<Post> query= ParseQuery.getQuery(Post.class);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.include(Post.KEY_USER);
        query.setLimit(20);

        query.addDescendingOrder(Post.CREATE_AT);
        query.findInBackground(new FindCallback<Post>() {

            @Override
            public void done(List<Post> fetchedPosts, ParseException e) {
                if (e!=null){
                    Log.e(TAG,"Issue with getting posts",e);
                    return;
                }
                for (Post post: fetchedPosts){
                    Log.i(TAG,"Post"+ post.getDescription()+ "user"+post.getUser().getUsername());
                }
                posts.clear();
                postAdapter.notifyDataSetChanged();;
                posts.addAll(fetchedPosts);
                postAdapter.notifyDataSetChanged();;
                swipeContainer.setRefreshing(false);
            }
        });

    }
}
