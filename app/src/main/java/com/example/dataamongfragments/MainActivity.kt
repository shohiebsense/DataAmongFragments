package com.example.dataamongfragments

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.dataamongfragments.fragment.dummy.DummyContent

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SectionsPagerAdapter.OnListFragmentInteractionListener {


    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    lateinit var firstListener : OnFragmentAffectedListener
    lateinit var secondListener : OnFragmentAffectedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter
        container.offscreenPageLimit = 3

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

    override fun onListFragmentInteraction(destPage : Int, item: DummyContent.DummyItem?) {
        Log.e("shohiebsensee ","page $destPage")
        when(destPage){
            0 -> firstListener.onFragmentAffected(destPage, item!!)
            1 -> secondListener.onFragmentAffected(destPage, item!!)
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */

    interface OnFragmentAffectedListener {
        fun onFragmentAffected(page : Int, item : DummyContent.DummyItem)
    }






}
