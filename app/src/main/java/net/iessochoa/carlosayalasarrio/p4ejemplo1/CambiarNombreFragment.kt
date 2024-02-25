package net.iessochoa.carlosayalasarrio.p4ejemplo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import net.iessochoa.carlosayalasarrio.p4ejemplo1.databinding.FragmentCambiarNombreBinding

class CambiarNombreFragment : Fragment() {

    private var _binding: FragmentCambiarNombreBinding? = null
    private val binding get() = _binding!!

    private val args: CambiarNombreFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCambiarNombreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Establece el nombre actual en el EditText
        binding.etCambiarNombre.setText(args.nombre)

        binding.btConfirmarCambio.setOnClickListener {
            // Obtiene el nombre modificado del EditText
            val nombreModificado = binding.etCambiarNombre.text.toString()

            // Crea la acción con el nombre modificado como argumento para regresar a SaludoFragment
            val action = CambiarNombreFragmentDirections.actionCambiarNombreFragmentToSaludoFragment(nombreModificado)

            // Navega de vuelta a SaludoFragment con el nuevo nombre
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}