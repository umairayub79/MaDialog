package umairayub.madialog

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import java.util.*

class MaDialog {

    class Builder(private val context: Context) {

        private var alertDialog: AlertDialog? = null
        private var positiveButtonListener: MaDialogListener? = null
        private var negativeButtonListener: MaDialogListener? = null

        private var title: String? = null
        private var message: String? = null
        private var positiveButtonText: String? = null
        private var negativeButtonText: String? = null

        private var buttonTextColor: Int = 0
        private var messageTextColor: Int = 0
        private var titleTextColor: Int = 0
        private var backgroundColor: Int = 0
        private var image: Int = 0
        private var gif: Int = 0
        private var fontID: Int = 0
        private var buttonOrientation: Int = 0

        private val buttons = ArrayList<Button>()

        private var cancelOnOutsideTouch = true


        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun setCustomFont(fontID: Int): Builder {
            this.fontID = fontID
            return this
        }

        fun setPositiveButtonListener(positiveButtonListener: MaDialogListener): Builder {
            this.positiveButtonListener = positiveButtonListener
            return this
        }

        fun setNegativeButtonListener(negativeButtonListener: MaDialogListener): Builder {
            this.negativeButtonListener = negativeButtonListener
            return this
        }

        fun setNegativeButtonText(negativeButtonText: String): Builder {
            this.negativeButtonText = negativeButtonText
            return this
        }

        fun setPositiveButtonText(positiveButtonText: String): Builder {
            this.positiveButtonText = positiveButtonText
            return this
        }

        fun setButtonTextColor(buttonTextColor: Int): Builder {
            this.buttonTextColor = buttonTextColor
            return this
        }

        fun setCancelableOnOutsideTouch(cancelOnOutsideTouch: Boolean): Builder {
            this.cancelOnOutsideTouch = cancelOnOutsideTouch
            return this
        }


        fun setBackgroundColor(backgroundColor: Int): Builder {
            this.backgroundColor = backgroundColor
            return this
        }


        fun setMessageTextColor(messageTextColor: Int): Builder {
            this.messageTextColor = messageTextColor
            return this
        }

        fun setGif(gif: Int): Builder {
            this.gif = gif
            return this
        }

        fun setImage(image: Int): Builder {
            this.image = image

            return this
        }

        fun setButtonOrientation(buttonOrientation: Int): Builder {
            this.buttonOrientation = buttonOrientation
            return this
        }

        fun setTitleTextColor(titleTextColor: Int): Builder {
            this.titleTextColor = titleTextColor
            return this
        }

        fun AddNewButton(@StyleRes style: Int, btnText: String, clickListener: MaDialogListener): Builder {
            val addbutton = Button(ContextThemeWrapper(context, style), null, style)
            val LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            LayoutParams.setMargins(8, 8, 8, 8)
            addbutton.layoutParams = LayoutParams
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                addbutton.textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
            addbutton.text = btnText
            addbutton.textSize = 16f
            addbutton.setOnClickListener {
                clickListener.onClick()
                alertDialog?.dismiss()
            }
            buttons.add(addbutton)
            return this
        }

        fun build() {

            alertDialog = AlertDialog.Builder(context).create()

            val view = LayoutInflater.from(context).inflate(R.layout.madialog, null)
            alertDialog?.setView(view)
            if (alertDialog?.window != null) {
                alertDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            alertDialog?.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            val tvTitle = view.findViewById<View>(R.id.tvTitleDisplay) as TextView
            val tvMessage = view.findViewById<View>(R.id.tvMessageDisplay) as TextView
            val btnPositve = view.findViewById<View>(R.id.btn_positive) as Button
            val btnNegative = view.findViewById<View>(R.id.btn_negative) as Button
            val imageView = view.findViewById<View>(R.id.imageView) as ImageView
            val root = view.findViewById<View>(R.id.rootly) as LinearLayout
            val ButtonContainer = view.findViewById<LinearLayout>(R.id.buttonLayout)

            if (buttonOrientation != 0) {
                ButtonContainer.orientation = buttonOrientation
            }
            for (i in buttons.indices) {
                ButtonContainer.addView(buttons[i])
            }


            if (message != null) {
                tvMessage.visibility = View.VISIBLE
            }
            if (title != null) {
                tvTitle.visibility = View.VISIBLE
            }
            tvMessage.text = message
            tvTitle.text = title
            if (image != 0) {
                imageView.visibility = View.VISIBLE
                imageView.setImageResource(image)
            }
            if (gif != 0) {
                imageView.visibility = View.VISIBLE
                Glide.with(context)
                        .asGif()
                        .load(gif)
                        .into(imageView)

            }
            if (fontID != 0) {
                val tf = ResourcesCompat.getFont(context, fontID)
                tvTitle.typeface = tf
                tvMessage.typeface = tf
                btnPositve.typeface = tf
                btnNegative.typeface = tf
            }
            if (messageTextColor != 0) {
                tvMessage.setTextColor(messageTextColor)
            }
            if (titleTextColor != 0) {
                tvTitle.setTextColor(titleTextColor)
            }
            if (backgroundColor != 0) {
                root.setBackgroundColor(backgroundColor)
            }
            if (buttonTextColor != 0) {
                btnNegative.setTextColor(buttonTextColor)
                btnPositve.setTextColor(buttonTextColor)
            }
            if (negativeButtonText != null) {
                btnNegative.text = negativeButtonText
            }
            if (positiveButtonText != null) {
                btnPositve.text = positiveButtonText
            }

            if (negativeButtonListener != null) {
                btnNegative.visibility = View.VISIBLE
                btnNegative.setOnClickListener {
                    negativeButtonListener!!.onClick()
                    alertDialog?.dismiss()
                }
            } else {
                btnNegative.visibility = View.GONE

            }
            if (positiveButtonListener != null) {
                btnPositve.visibility = View.VISIBLE
                btnPositve.setOnClickListener {
                    positiveButtonListener!!.onClick()
                    alertDialog?.dismiss()
                }
            } else {
                btnPositve.visibility = View.GONE

            }
            if (cancelOnOutsideTouch) {
                alertDialog?.setCanceledOnTouchOutside(true)
            } else {
                alertDialog?.setCanceledOnTouchOutside(false)

            }
            alertDialog?.show()
        }
    }
}
