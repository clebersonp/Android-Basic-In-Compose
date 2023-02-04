package br.com.myapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import br.com.myapp.databinding.FragmentFirstBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

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

        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

            // Passo a passo na criacao do projeto no firebase
            // https://stackoverflow.com/questions/69163511/build-was-configured-to-prefer-settings-repositories-over-project-repositories-b
            // https://stackoverflow.com/questions/48610901/only-build-script-and-other-plugins-script-blocks-are-allowed-before-plugins
            // https://docs.aws.amazon.com/sns/latest/dg/sns-send-custom-platform-specific-payloads-mobile-devices.html
            // https://firebase.google.com/docs/cloud-messaging/http-server-ref
            // https://firebase.google.com/docs/cloud-messaging/android/send-image#rest
            // Ativar o API Cloud Messaging (legada) para recuperar o token que o AWS SNS necessita.

            /*
             * Exemplo do payload do AWS SNS com titulo, msg e imagem:
             *
             *   {
             *       "GCM": "{ \"notification\":
             *                  { \"title\":\"Título Teste\",\"body\": \"Teste ação\",
             *                      \"image\":\"UrlImage\"},
             *                      \"data\":{\"link\": \"view_05\", \"id\":123456}}"
             *   }
             */
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    return@OnCompleteListener
                }

                var token = task.result

                Toast.makeText(context, token, Toast.LENGTH_LONG).show()

                var clipboardManager = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                var clipData = ClipData.newPlainText("text", token)
                clipboardManager.setPrimaryClip(clipData)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}