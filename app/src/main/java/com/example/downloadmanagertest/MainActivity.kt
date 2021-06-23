package com.example.downloadmanagertest

import android.app.DownloadManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * notification無法客製與操控後續行為，捨棄
 */

const val DOWNLOAD_URL = "http://moi.kcwu.csie.org/MOI_OSM_Taiwan_TOPO_Rudy.map.zip"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        val req = DownloadManager.Request(Uri.parse(DOWNLOAD_URL))
            .setDestinationInExternalFilesDir(this, "DownloadFiles", "MOI_OSM_Taiwan_TOPO_Rudy.map.zip")
            .setTitle("下載測試")
            .setDescription("MOI_OSM_Taiwan_TOPO_Rudy.map.zip")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        val id = dm.enqueue(req)
    }
}