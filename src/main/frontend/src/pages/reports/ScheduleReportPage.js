import React, {useEffect, useState} from "react";
import BackButton from "../../components/UI/buttons/BackButton/BackButton";
import LessonTable from "../../components/lesson/LessonTable/LessonTable";
import LessonService from "../../service/api/LessonService";
import {parseTimestamp} from "../../utils/DateUtils";
import AddLessonForm from "../../components/forms/AddLessonForm/AddLessonForm";

export default function ScheduleReportPage() {

    const [lessons, setLessons] = useState([])

    useEffect(() => {
        LessonService.getSchedule()
            .then(res => {
                let lessonArray = res.data.map(lesson => {
                    let lessonBuffer = []
                    for (let lessonInfoIndex in lesson.lessons) {
                        let lessonInfo = lesson.lessons[lessonInfoIndex]
                        lessonBuffer.push({
                            ...lessonInfo,
                            departmentName: lesson.departmentName
                        })
                    }
                    return lessonBuffer
                })
                    .flat(1)
                    .sort(function(a, b) {
                        return parseTimestamp(a.dateStart) - parseTimestamp(b.dateStart)
                    })
                setLessons(lessonArray)
                console.log(lessonArray)
            })
    }, [])

    function deleteLessonFromTable(id) {
        setLessons(prevState => {
            return prevState.filter(lesson => lesson.id !== id)
        })
    }

    function onAfterSave(newLesson) {
        console.log(newLesson)
        const departmentName = newLesson.departmentName
        const lesson = newLesson.lessons[0]

        setLessons(prevState => {
            return [
                ...prevState,
                {
                    departmentName: departmentName,
                    dateEnd: lesson.dateEnd,
                    dateStart: lesson.dateEnd,
                    disciplineName: lesson.disciplineName,
                    groupName: lesson.groupName,
                    room: lesson.room,
                    teacherName: lesson.teacherName
                }
            ]
        })
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Расписание</h1>
            </div>
            <div className="mb-3">
                <LessonTable lessons={lessons} onDelete={deleteLessonFromTable}/>
            </div>
            <div className="mb-3">
                <AddLessonForm
                    onAfterSave={onAfterSave}
                />
            </div>
            <div className="mb-3">
                <BackButton to="/"/>
            </div>
        </div>
    )
}