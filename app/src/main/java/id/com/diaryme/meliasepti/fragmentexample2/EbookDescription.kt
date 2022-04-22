package id.com.diaryme.meliasepti.fragmentexample2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.ebook_description.*

class EbookDescription : Fragment() {

    lateinit var arrebookdesc: Array<String>
    var ebookindex = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.ebook_description, container, false)
        arrebookdesc = resources.getStringArray(R.array.ebookdescriptions)
        ebookindex = if (savedInstanceState?.getInt("ebookindex") == null) 0 else {
            savedInstanceState.getInt("ebookindex")
        }
        return v
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("ebookindex", ebookindex)
    }

    fun changeDescription(index: Int): Unit {
        ebookindex = index
        println("EBOOK INDEx = $ebookindex")
        txtdescription?.setText(arrebookdesc[ebookindex])
        println(arrebookdesc[ebookindex])
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeDescription(ebookindex)
    }
}