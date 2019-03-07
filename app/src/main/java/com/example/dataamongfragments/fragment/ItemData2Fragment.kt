package com.example.dataamongfragments.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dataamongfragments.MainActivity
import com.example.dataamongfragments.R
import com.example.dataamongfragments.SectionsPagerAdapter
import com.example.dataamongfragments.adapter.MyItemDataRecyclerViewAdapter2

import com.example.dataamongfragments.fragment.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ItemData2Fragment.OnListFragmentInteractionListener] interface.
 */
class ItemData2Fragment : Fragment(), MainActivity.OnFragmentAffectedListener {

    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: SectionsPagerAdapter.OnListFragmentInteractionListener? = null
    lateinit var mainActivity : MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainActivity = (activity as MainActivity)
        mainActivity.secondListener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_itemdata_list2, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyItemDataRecyclerViewAdapter2(DummyContent.ITEMS, listener)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SectionsPagerAdapter.OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemData2Fragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun onFragmentAffected(page: Int, item: DummyContent.DummyItem) {
        if(page == 1)
        Toast.makeText(activity, "second fragment ", Toast.LENGTH_LONG).show()
    }

}
