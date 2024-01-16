import React, {useEffect, useState} from "react";
import BackButton from "../../components/UI/buttons/BackButton/BackButton";
import LessonTable from "../../components/lesson/LessonTable/LessonTable";
import LessonService from "../../service/api/LessonService";
import {parseTimestamp} from "../../utils/DateUtils";
import DepartmentService from "../../service/api/DepartmentService";

export default function DepartmentScheduleReportPage() {

    const [lessons, setLessons] = useState([])
    const [departments, setDepartments] = useState([])

    const [selectedDepartmentId, setSelectedDepartmentId] = useState(0)

    useEffect(() => {
        DepartmentService.getAll()
            .then(res => {
                setDepartments(res.data)
                setSelectedDepartmentId(res.data[0].id)
            })
            .catch(e => console.log(e))
    }, [])

    useEffect(() => {
        if (selectedDepartmentId) {
            LessonService.getDepartmentSchedule(selectedDepartmentId)
                .then(res => {
                    if (!res.data.lessons) {
                        return
                    }

                    const departmentName = res.data.departmentName

                    let lessonArray = res.data.lessons.map(lesson => {
                        return {
                            ...lesson,
                            departmentName: departmentName
                        }
                    })
                        .sort(function (a, b) {
                            return parseTimestamp(a.dateStart) - parseTimestamp(b.dateStart)
                        })
                    setLessons(lessonArray)
                })
        }
    }, [selectedDepartmentId])

    function handleDepartmentChange(e) {
        setSelectedDepartmentId(e.target.value)
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Расписание</h1>
            </div>
            <div className="mb-3">
                <div className="row mb-3">
                    <label htmlFor="departmentId" className="form-label ms-2">Кафедра</label>
                    <select id="departmentId" className="form-select"
                            value={selectedDepartmentId}
                            onChange={(e) => handleDepartmentChange(e)}>
                        {
                            departments.map(department => {
                                return <option value={department.id} key={department.id}>{department.name}</option>
                            })
                        }
                    </select>
                </div>
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