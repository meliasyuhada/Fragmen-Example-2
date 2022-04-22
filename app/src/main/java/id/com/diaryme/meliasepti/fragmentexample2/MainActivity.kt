package id.com.diaryme.meliasepti.fragmentexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(), Coordinator {

    lateinit var fragEbookDescription: EbookDescription
    lateinit var fragEbookTitle: EbookTitle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragEbookTitle = EbookTitle()
        fragEbookDescription = EbookDescription()
        val fragTransaction = supportFragmentManager.beginTransaction()
        fragTransaction.add(R.id.fragtop, fragEbookTitle)
        fragTransaction.add(R.id.fragbottom, fragEbookDescription)
        fragTransaction.commit()
    }

    override fun onEbookChanged(index: Int) {
        fragEbookDescription.changeDescription(index)
    }
}