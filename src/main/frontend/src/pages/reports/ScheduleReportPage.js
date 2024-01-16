import React, {useEffect, useState} from "react";
import BackButton from "../../components/UI/buttons/BackButton/BackButton";
import LessonTable from "../../components/lesson/LessonTable/LessonTable";
import LessonService from "../../service/api/LessonService";
import {parseTimestamp} from "../../utils/DateUtils";

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
            })
    }, [])

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Расписание</h1>
            </div>
            <div className="mb-3">
                <LessonTable lessons={lessons}/>
            </div>
            <div className="mb-3">
                <BackButton to="/"/>
            </div>
        </div>
    )
}