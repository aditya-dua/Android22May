package com.acadgild.fragmentexamplesession9;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
        HeadlinesFragment.OnHeadlineSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);
        //We have to check if its a frame Layout
        //Toast.makeText(getApplicationContext(),"MainActivity :: onCreate",Toast.LENGTH_SHORT).show();
        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState !=null){
                return;
            }
            HeadlinesFragment firstFragment = new HeadlinesFragment();
            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container,firstFragment).commit();
            //Toast.makeText(getApplicationContext(),"MainActivity :: Headline Fragment Created",Toast.LENGTH_LONG).show();

        }


    }
    /** This is listener **/
    @Override
    public void onArticleSelected(int position) {

        Toast.makeText(getApplicationContext(),"MainActivity :: onArticleSelectedCalled",Toast.LENGTH_SHORT).show();

        ArticleFragments articleFragments=(ArticleFragments)
                getSupportFragmentManager()
                .findFragmentById(R.id.article_fragment);
        if(articleFragments != null){
            articleFragments.updateArticleView(position);
            Toast.makeText(getApplicationContext(),"MainActivity :: UpdateArticle",Toast.LENGTH_SHORT).show();

        }else{
            ArticleFragments newFragment=new ArticleFragments();
            Bundle args=new Bundle();
            args.putInt(ArticleFragments.ARG_POSITION,position);
            newFragment.setArguments(args);

            FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            Toast.makeText(getApplicationContext(),"MainActivity :: Fragment Transaction",Toast.LENGTH_SHORT).show();

            transaction.replace(R.id.fragment_container,newFragment)
                        .addToBackStack(null)
                        .commit();
            //transaction.addToBackStack(null);
           // transaction.commit();

        }

    }
}
