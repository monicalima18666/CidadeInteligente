package ipvc.estg.cidadeinteligente.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ipvc.estg.cidadeinteligente.entities.Nota

interface NotaDao {

    @Query("SELECT * FROM nota_table ORDER BY titulo ASC")
    fun getAlphabetizedWords(): LiveData<List<Nota>>

//    @Query("SELECT * FROM nota_table WHERE descricao == :name")
//    fun getTitulosFromDescricao(name: String): LiveData<List<Nota>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(nota: Nota)

    @Query("DELETE FROM nota_table")
    suspend fun deleteAll()

    @Update
    suspend fun updateNota(nota: Nota)

    @Query("DELETE FROM nota_table where titulo == :titulo")
    suspend fun deleteByCity(titulo: String)

    @Query("UPDATE nota_table SET descricao=:descricao WHERE titulo == :titulo")
    suspend fun updateDescricaoFromTitulo(titulo: String, descricao: String)
}
