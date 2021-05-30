package com.example.lesson

import android.widget.Toast
import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author wangyou
 * @desc:
 * @date :2021/4/29
 */
class LessonPresenter {
    companion object{
        const val LESSON_PATH = "lessons";
    }
    private var activity:LessonActivity

    constructor(activity: LessonActivity){
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson>>(){}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity.runOnUiThread { activity.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread {
                    if (message != null) {
                        Utils.toast(message, Toast.LENGTH_SHORT)
                    }
                }
            }
        })
    }

    fun showPlayback() {
        var playbackLessons:ArrayList<Lesson> = ArrayList()
//        var playbackLessons = arrayListOf<Lesson>()
        for (lesson in lessons){
            if (lesson.getState() == Lesson.State.PLAYBACK){
                playbackLessons.add(lesson)
            }
        }
        activity.showResult(playbackLessons)
    }
}