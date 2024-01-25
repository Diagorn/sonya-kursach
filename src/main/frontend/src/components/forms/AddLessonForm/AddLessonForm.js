import React, {useEffect, useState} from "react";
import CreateButton from "../../UI/buttons/CreateButton/CreateButton";
import GroupService from "../../../service/api/GroupService";
import EmployeeService from "../../../service/api/EmployeeService";
import DisciplineService from "../../../service/api/DisciplineService";
import LessonService from "../../../service/api/LessonService";
import {alertError} from "../../../utils/ExceptionUtils";

export default function AddLessonForm(props) {

    const [lesson, setLesson] = useState({
        group: {},
        employee: {},
        discipline: {}
    })
    const [groups, setGroups] = useState([])
    const [employees, setEmployees] = useState([])
    const [disciplines, setDisciplines] = useState([])

    const [selectedGroupId, setSelectedGroupId] = useState(1)
    const [selectedEmployeeId, setSelectedEmployeeId] = useState(1)
    const [selectedDisciplineId, setSelectedDisciplineId] = useState(1)

    useEffect(() => {
        GroupService.getAll()
            .then(res => setGroups(res.data))
            .catch(e => console.log(e))

        EmployeeService.getAllEmployees()
            .then(res => setEmployees(res.data))
            .catch(e => console.log(e))

        DisciplineService.getAll()
            .then(res => setDisciplines(res.data))
            .catch(e => console.log(e))
    }, [])

    useEffect(() => {
        DisciplineService.getByEmployeeId(selectedEmployeeId)
            .then(res => setDisciplines(res.data))
            .catch(e => console.log(e))
    }, [selectedEmployeeId])

    function handleChange(e) {
        let {id, value} = e.target

        setLesson(prevState => {
            return {
                ...prevState,
                [id]: value
            }
        })
    }

    function handleEmployeeChange(e) {
        setSelectedEmployeeId(e.target.value)
    }

    function handleDisciplineChange(e) {
        setSelectedDisciplineId(e.target.value)
    }

    function handleGroupChange(e) {
        setSelectedGroupId(e.target.value)
    }

    function save() {
        const lessonRequest = {
            ...lesson,
            disciplineId: selectedDisciplineId,
            groupId: selectedGroupId,
            teacherId: selectedEmployeeId
        }

        LessonService.addLesson(lessonRequest)
            .then(res => props.onAfterSave(res.data))
            .catch(e => alertError(e))
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <form noValidate={true}>
                    <div className="mb-3">
                        <label htmlFor="dateRecieve" className="form-label">Дата начала</label>
                        <input type="datetime-local" className="form-control" id="dateBegin"
                               value={lesson.dateBegin} onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="dateRecieve" className="form-label">Дата конца</label>
                        <input type="datetime-local" className="form-control" id="dateEnd"
                        value={lesson.dateEnd} onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="room" className="form-label">Аудитория</label>
                        <input type="text" className="form-control" id="room" value={lesson.room}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="selectedEmployeeId" className="form-label ms-2">Сотрудник</label>
                        <select id="selectedEmployeeId" className="form-select"
                                value={selectedEmployeeId}
                                onChange={(e) => handleEmployeeChange(e)}>
                            {
                                employees.map(emp => {
                                    return <option value={emp.id}>{emp.fio}</option>
                                })
                            }
                        </select>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="selectedDisciplineId" className="form-label ms-2">Дисциплина</label>
                        <select id="selectedDisciplineId" className="form-select"
                                value={selectedDisciplineId}
                                onChange={(e) => handleDisciplineChange(e)}>
                            {
                                disciplines.map(discipline => {
                                    return <option value={discipline.id}>{discipline.name}</option>
                                })
                            }
                        </select>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="selectedGroupId" className="form-label ms-2">Группа</label>
                        <select id="selectedGroupId" className="form-select"
                                value={selectedGroupId}
                                onChange={(e) => handleGroupChange(e)}>
                            {
                                groups.map(group => {
                                    return <option value={group.id}>{group.name}</option>
                                })
                            }
                        </select>
                    </div>
                </form>
                <div className="mb-3">
                    <div className="me-2 d-inline-block">
                        <CreateButton btnCallback={save} className="mr-3"/>
                    </div>
                </div>
            </div>
        </div>
    )
}