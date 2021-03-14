package ipvc.estg.cidadeinteligente.viewModel

import android.app.Application
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ipvc.estg.cidadeinteligente.db.NotaDB
import ipvc.estg.cidadeinteligente.db.NotaRepository
import ipvc.estg.cidadeinteligente.entities.Nota
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotaViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: NotaRepository

    val allNotas: LiveData<List<Nota>>


    init {
        val notasDao = NotaDB.getDatabase(application, viewModelScope).notaDao()
        repository = NotaRepository(notasDao)
        allNotas = repository.allNotas
    }



    // delete all
    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }

    // delete by city
    fun deleteByTitulo(titulo : String) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteByTitulo(titulo)
    }

    fun getTitulosFromDescricao(descricao: String): LiveData<List<Nota>> {
        return repository.getTitulosFromDescricao(descricao)
    }

    fun getDescricaoFromTitulos(titulo: String): LiveData<List<Nota>> {
        return repository.getDescricaoFromTitulos(titulo)
    }

    fun updateNota (nota: Nota) = viewModelScope.launch {
        repository.updateNota(nota)
    }

    fun updateDescricaoFromTitulo(titulo: String, descricao: String) = viewModelScope.launch {
        repository.updateDescricaoFromTitulo(titulo, descricao)
    }

    fun insert(nota: Nota) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(nota)

    }
}