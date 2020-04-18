package com.example.cryptoapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CryptoListFragment : Fragment() {
    private val TAG = "CryptoListFragment"
    private lateinit var cryptoRecyclerView: RecyclerView
    private var adapter: CryptoAdapter? = null

    private val cryptoListViewModel: CryptoListViewModel by lazy {
        ViewModelProviders.of(this).get(CryptoListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total Cryptos: ${cryptoListViewModel.cryptos.size}")
    }

    companion object {
        fun newInstance(): CryptoListFragment {
            return CryptoListFragment()
        }
    }

    private inner class CryptoHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var crypto: Crypto
        private val titleTextView: TextView = itemView.findViewById(R.id.crypto_title)
        private val priceTextView: TextView = itemView.findViewById(R.id.price)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(crypto: Crypto) {
            this.crypto = crypto
            titleTextView.text = this.crypto.cryptoName
            priceTextView.text = this.crypto.price.toString()
        }

        override fun onClick(v: View) {
            Toast.makeText(context, "${crypto.cryptoName} pressed!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crypto_list, container, false)

        cryptoRecyclerView = view.findViewById(R.id.crypto_recycler_view) as RecyclerView
        cryptoRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI()
        return view
    }

    private fun updateUI() {
        val cryptos = cryptoListViewModel.cryptos
        adapter = CryptoAdapter(cryptos)
        cryptoRecyclerView.adapter = adapter
    }

    private inner class CryptoAdapter(var cryptos: List<Crypto>) :
        RecyclerView.Adapter<CryptoHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : CryptoHolder {
            val view = layoutInflater.inflate(R.layout.list_item_crypto, parent, false)
            return CryptoHolder(view)
        }

        override fun getItemCount() = cryptos.size

        override fun onBindViewHolder(holder: CryptoHolder, position: Int) {
            val crypto = cryptos[position]
            holder.bind(crypto)
        }
    }
}