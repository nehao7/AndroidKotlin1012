package com.o7services.androidkotlin10_12.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.o7services.androidkotlin10_12.R
import com.o7services.androidkotlin10_12.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        Toast.makeText(requireContext(), "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFirstBinding.inflate(layoutInflater)
        Toast.makeText(requireContext(), "onCreateView", Toast.LENGTH_SHORT).show()

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "onViewCreated", Toast.LENGTH_SHORT).show()

        binding.btnNext.setOnClickListener {
            if(binding.edt.text.toString().isNullOrEmpty()){
                Toast.makeText(requireContext(), "enter data first", Toast.LENGTH_SHORT).show()

            }else{
            var bundle=Bundle()
            bundle.putString("value",binding.edt.text.toString())
            findNavController().navigate(R.id.secondFragment,bundle)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(requireContext(), "onStart", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(requireContext(), "onResume", Toast.LENGTH_SHORT).show()

    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(requireContext(), "OnPause", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(requireContext(), "OnStop", Toast.LENGTH_SHORT).show()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Toast.makeText(requireContext(), "OnSaveInstanceState", Toast.LENGTH_SHORT).show()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(requireContext(), "onDestroyView", Toast.LENGTH_SHORT).show()

    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(requireContext(), "onDetach", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(requireContext(), "OnDestroy", Toast.LENGTH_SHORT).show()


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}