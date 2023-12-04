package br.com.nexus.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.nexus.model.Produto
import br.com.nexus.sampledata.sampleProduto

class ProdutoDao {
    companion object {
        private val produtos = mutableStateListOf<Produto>()
    }
    fun produtos() = produtos.toList()

    fun save(produto: Produto) {
        produtos.add(produto)
    }
}