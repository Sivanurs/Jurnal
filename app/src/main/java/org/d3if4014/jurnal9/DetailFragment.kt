package org.d3if4014.jurnal9

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.d3if4014.jurnal9.databinding.FragmentDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
 //
    private lateinit var binding: FragmentDetailBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        Log.i("tesAr", DetailMiwok.selectedMiwok.toString())
        viewManager = LinearLayoutManager(context)
        viewAdapter = MiwokDetailAdapter(DetailMiwok.selectedMiwok)
        recyclerView = binding.rvDetailMiwok.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return binding.root
    }

}
