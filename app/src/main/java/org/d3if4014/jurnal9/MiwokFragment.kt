package org.d3if4014.jurnal9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ghapi.overview.MiwokViewModel
import org.d3if4014.jurnal9.databinding.FragmentMiwokBinding

/**
 * A simple [Fragment] subclass.
 */
class MiwokFragment : Fragment() {

    private lateinit var binding: FragmentMiwokBinding
    private lateinit var miwokVM: MiwokViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_miwok, container, false)
        miwokVM = ViewModelProviders.of(this).get(MiwokViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.miwokVM = miwokVM

        viewManager = LinearLayoutManager(context)
        miwokVM.items.observe(viewLifecycleOwner, Observer {
            viewAdapter = MiwokAdapter(it)
            recyclerView = binding.rvMiwok.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        })

        return binding.root
    }

}
