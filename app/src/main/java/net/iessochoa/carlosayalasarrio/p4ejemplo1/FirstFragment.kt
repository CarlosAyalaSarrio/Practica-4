package net.iessochoa.carlosayalasarrio.p4ejemplo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import net.iessochoa.carlosayalasarrio.p4ejemplo1.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.btName.setOnClickListener(){

            findNavController().navigate(R.id.action_FirstFragment_to_saludoFragment
            )
        }

        binding.btName.setOnClickListener(){
// findNavController().navigate(R.id.action_FirstFragment_to_saludoFragment)
            //buscamos el nombre
            val nombre=binding.etName.text.toString()
            //creamos la acción pasándole el valor como argumento
            val action=FirstFragmentDirections.actionFirstFragmentToSaludoFragment(nombre)
            //abrimos SaludoFragment
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}