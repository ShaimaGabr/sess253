package com.example.sess25.story

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.CursorAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.sess25.CustomAdapter
import com.example.sess25.databinding.FragmentStoryfragmentBinding


class storyfragment : Fragment() {

lateinit var binding:FragmentStoryfragmentBinding
val mview: StoryViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= FragmentStoryfragmentBinding.inflate(inflater)
        binding.lifecycleOwner=this
       // binding.model=StoryModel("dfgj","bnnm","https://www.imagesource.com/wp-content/uploads/2019/06/Rio.jpg",1)
        binding.viewModel=mview

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//     binding.button.setOnClickListener {
//     binding.text.text=mview.one2.value
//     }
        mview.one2.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()){
                binding.text.text=it
            }
        })
        ////////////////////////////////call Api
        mview.getdatafromserver(binding.edit,requireContext())//////دي ممكن تتحط في ال onclick ""
       // @{()-> mview.getdatafromserver(edit)}
        mview.newsList.observe(viewLifecycleOwner, Observer {
            binding.res.adapter=CustomAdapter(it)

        })
    }



}