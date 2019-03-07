package com.example.dataamongfragments

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.dataamongfragments.fragment.ItemData2Fragment
import com.example.dataamongfragments.fragment.ItemData3Fragment
import com.example.dataamongfragments.fragment.ItemDataFragment
import com.example.dataamongfragments.fragment.dummy.DummyContent

class SectionsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {



    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return when(position){
            0 -> ItemDataFragment.newInstance(1)
            1 -> ItemData2Fragment.newInstance(2)
            else -> ItemData3Fragment.newInstance(1)
        }
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }






    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(destinationPage : Int, item: DummyContent.DummyItem?)
    }


}