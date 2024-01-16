import React from "react";
import LessonRow from "../LessonRow/LessonRow";

export default function LessonTable(props) {

    return (
        <table className="table table-striped">
            <thead>
            <tr>
                <th scope="col">Наименование кафедры</th>
                <th scope="col">Дата начала</th>
                <th scope="col">Дата конца</th>
                <th scope="col">Аудитория</th>
                <th scope="col">Дисциплина</th>
                <th scope="col">Группа</th>
                <th scope="col">Преподаватель</th>
            </tr>
            </thead>
            <tbody>
            {
                props.lessons.map(lesson => {
                    return <LessonRow
                        lesson={lesson}
                    />
                })
            }
            </tbody>
        </table>
    )
}