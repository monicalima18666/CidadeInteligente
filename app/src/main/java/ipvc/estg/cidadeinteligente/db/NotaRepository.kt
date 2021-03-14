package ipvc.estg.cidadeinteligente.db

import androidx.lifecycle.LiveData
import ipvc.estg.cidadeinteligente.dao.NotaDao
import ipvc.estg.cidadeinteligente.entities.Nota

class NotaRepository(private val notaDao: NotaDao) {

    // Observed LiveData will notify the observer when the data has changed.
    val allNotas: LiveData<List<Nota>> = notaDao.getAllNotas()

    fun getTitulosFromDescricao(descricao: String): LiveData<List<Nota>> {
        return notaDao.getTitulosFromDescricao(descricao)
    }

    fun getDescricaoFromTitulos(titulo: String): LiveData<List<Nota>> {
        return notaDao.getDescricaoFromTitulos(titulo)
    }

    suspend fun insert(nota: Nota) {
        notaDao.insert(nota)
    }

    suspend fun deleteAll(){
        notaDao.deleteAll()
    }

    suspend fun deleteByTitulo(titulo: String){
        notaDao.deleteByTitulo(titulo)
    }

    suspend fun updateNota(nota: Nota) {
        notaDao.updateNota(nota)
    }

    suspend fun updateDescricaoFromTitulo(titulo: String, descricao: String){
        notaDao.updateDescricaoFromTitulo(titulo, descricao)
    }

}