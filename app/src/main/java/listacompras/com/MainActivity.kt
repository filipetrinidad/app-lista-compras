package listacompras.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt_produto = findViewById<EditText>(R.id.txt_produto)
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)
        val list_view = findViewById<ListView>(R.id.list_view_produtos)

        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        list_view.adapter = produtosAdapter

        btn_inserir.setOnClickListener {
            val produto = txt_produto.text.toString()
            if(produto.isNotEmpty()){
                produtosAdapter.add(produto)
                txt_produto.text.clear()
            }
            else{
                txt_produto.error = "Por favor preencha o campo"
            }

        }

        list_view.setOnItemLongClickListener{ adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }
    }
}