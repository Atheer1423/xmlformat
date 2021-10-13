package com.example.xmlformat

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class parser {
lateinit var text:String
lateinit var StudentName:String
 var marks:Float=0.0f
 var id=0
    var studentArray=ArrayList<Students>()

    fun parse (inputStream :InputStream):ArrayList<Students>{
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("name", ignoreCase = true) -> {
                            StudentName = text.toString()
                        }
                        tagName.equals("marks", ignoreCase = true) -> {
                            marks = text.toFloat()
                        }
                        tagName.equals("id", ignoreCase = true) -> {
                            id = text.toInt()
                        }
                        else -> studentArray.add(Students(id,StudentName, marks))
                    }

                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return studentArray

    }
}