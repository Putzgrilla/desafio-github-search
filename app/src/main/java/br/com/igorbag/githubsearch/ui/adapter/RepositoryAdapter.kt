package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = repositories[position]

        // Bind do nome do repositório
        holder.nomeRepositorio.text = repository.name

        // Click no item para abrir o browser
        holder.itemView.setOnClickListener {
            carItemLister(repository)
        }

        // Click no botão de compartilhar
        holder.btnShare.setOnClickListener {
            btnShareLister(repository)
        }
    }

    // Pega a quantidade de repositorios da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeRepositorio: TextView
        val btnShare: ImageView

        init {
            view.apply {
                nomeRepositorio = findViewById(R.id.tv_preco)
                btnShare = findViewById(R.id.iv_favorite)
            }
        }
    }
}