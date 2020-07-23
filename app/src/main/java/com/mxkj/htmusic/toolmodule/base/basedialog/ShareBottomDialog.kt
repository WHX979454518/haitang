package com.mxkj.htmusic.toolmodule.base.basedialog

import android.app.Dialog
import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.WindowManager
import android.widget.*

import com.flyco.dialog.widget.base.BottomBaseDialog
import com.mxkj.htmusic.R
import com.mxkj.htmusic.projectmodule.adapter.ReportOperationAdapter
import com.mxkj.htmusic.projectmodule.bean.ReportOperationBean
import com.mxkj.htmusic.toolmodule.base.BaseQuickAdapter
import com.mxkj.htmusic.toolmodule.base.BaseViewHolder

import java.util.ArrayList

class ShareBottomDialog(context: Context, private var musicBean: MusicBean) : BottomBaseDialog<ShareBottomDialog>(context) {
    private var tv_cancel: TextView? = null
    private var layout_dismiss: RelativeLayout? = null
    private var recyclerView: RecyclerView? = null
    private var shareBeanList: MutableList<ShareBean>? = null
    private var shareBottomAdapter: ShareBottomAdapter? = null

    override fun onCreateView(): View {
        showAnim(null)
        dismissAnim(null)
        val inflate = View.inflate(mContext, R.layout.dialog_share, null)
        tv_cancel = inflate.findViewById(R.id.tv_cancel)
        recyclerView = inflate.findViewById(R.id.recyclerView)
        layout_dismiss = inflate.findViewById(R.id.layout_dismiss)
        getShareContents(musicBean)
        return inflate
    }


    internal lateinit var wm:WindowManager;
    internal lateinit var progressbar: ProgressBar
    internal var inflate:View? = null
    internal var dialog:Dialog? = null
    private var reportOperationBeanList: MutableList<ReportOperationBean.DataBean> = ArrayList()
    private lateinit var reportOperationAdapter: ReportOperationAdapter
    internal lateinit var recyclerview:RecyclerView
    internal lateinit var tv_cancle:TextView

    private fun getShareContents(musicBean: MusicBean) {
        shareBeanList = ArrayList()
        val shareDataBean = musicBean.getShareDataBean()
        val type = shareDataBean!!.type
        val mv = shareDataBean!!.mv
//        if (type != "musician" && type != "web") {
//            shareBeanList!!.add(ShareBean(R.drawable.share_yyt, "yyt", "源音塘"))
//        }
        if (type != "musician") {
            shareBeanList!!.add(ShareBean(R.drawable.ic_launcher, "yyt", "微信塘"))
        }

        shareBeanList!!.add(ShareBean(R.drawable.ic_launcher, "wechat", "微信"))
        shareBeanList!!.add(ShareBean(R.drawable.ic_launcher, "pwechat", "朋友圈"))
        shareBeanList!!.add(ShareBean(R.drawable.ic_launcher, "qq", "QQ"))
        shareBeanList!!.add(ShareBean(R.drawable.ic_launcher, "sina", "新浪"))
        shareBeanList!!.add(ShareBean(R.drawable.ic_launcher, "qzone", "QQ空间"))
        if (type != "img") {
            shareBeanList!!.add(ShareBean(R.drawable.ic_launcher, "copy", "复制链接"))
        }

        shareBeanList!!.add(ShareBean(R.drawable.ic_launcher, "report", "举报"))

        recyclerView!!.layoutManager = GridLayoutManager(mContext, 5) as RecyclerView.LayoutManager?
        shareBottomAdapter = ShareBottomAdapter()
        recyclerView!!.adapter = shareBottomAdapter

    }

    override fun setUiBeforShow() {
        tv_cancel!!.setOnClickListener { dismiss() }
        layout_dismiss!!.setOnClickListener { dismiss() }
    }


    private inner class ShareBottomAdapter : BaseQuickAdapter<ShareBean, BaseViewHolder>(R.layout.item_share, shareBeanList) {

        override fun convert(helper: BaseViewHolder, item: ShareBean, position: Int) {
            helper.setImageResource(R.id.iv_img, item.drawable)
            helper.setText(R.id.tv_txt, item.txt)
        }
    }
}
