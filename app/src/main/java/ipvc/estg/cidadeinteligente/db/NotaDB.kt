package ipvc.estg.cidadeinteligente.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import ipvc.estg.cidadeinteligente.dao.NotaDao
import ipvc.estg.cidadeinteligente.entities.Nota
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = arrayOf(Nota::class), version = 8, exportSchema = false)

abstract class NotaDB : RoomDatabase() {

    abstract fun notaDao(): NotaDao



    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var notaDao = database.notaDao()

                    // Delete all content here.
                    notaDao.deleteAll()

                    // Add sample cities.
                    var nota = Nota (1, "TRANSITO", "RUA 25 DE ABRIL")
                    notaDao.insert(nota)
                    nota = Nota(2, "Obras", "Perto de casa")
                    notaDao.insert(nota)
                    nota = Nota(3, "Tampa", "Desviada")
                    notaDao.insert(nota)

                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NotaDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): NotaDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotaDB::class.java,
                    "notas_database",
                )
                    //estratégia de destruição
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}