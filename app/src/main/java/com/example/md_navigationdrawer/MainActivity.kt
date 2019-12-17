package com.example.md_navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_navigation_layout.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    MyAdapter.OnClickItem {
    var list: MutableList<model> = mutableListOf()
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNavigationDawer()

        createRecyclerView()
    }

    fun createRecyclerView() {
        createData()
        recyler.layoutManager = LinearLayoutManager(this)
        recyler.setHasFixedSize(true)
        adapter = MyAdapter(list, this)
        recyler.adapter = adapter

    }

    fun createData() {
        //val model1: model? =null

        for (i in 1..10) {
            val model = model(
                i.toString(),
                "hjgasfgasfgyasdjfgsadjhfgasdhfhgasjfjvhasjfgvasdjfvasdfvhasdfha",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a"
            )
            list.add(model)
        }
    }

    fun createNavigationDawer() {
        toolbar.title = "Việt Nam"

        val toggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        navigation.setNavigationItemSelectedListener(this)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        var message = p0.title
        Toast.makeText(applicationContext, "$message", Toast.LENGTH_SHORT).show()

//        if (p0.isChecked()) {
//            p0.setChecked(false)
//        }
//        else
//            p0.setChecked(true)
        //p0.setChecked((true))
        closeDrawer()
        when (p0.itemId) {
            R.id.daBong -> {

            }
            R.id.bongChuyen -> {
            }
            R.id.bongBan -> {
            }
            R.id.bongTo -> {
            }
            R.id.cauLong -> {
            }
            R.id.chayBo -> {
            }
            R.id.daCau -> {
            }
            R.id.nhayCau -> {
            }
            R.id.nhayDay -> {
            }
        }
        closeDrawer()
        return false
    }

    private fun closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            closeDrawer()
        } else {
            super.onBackPressed()
        }
    }

    override fun onClick(model: model) {
        Toast.makeText(this, "${model.s1}  ${model.s2}", Toast.LENGTH_SHORT).show()
    }

}
