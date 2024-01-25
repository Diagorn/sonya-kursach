import React from "react";
import {formatTimestamp} from "../../../utils/DateUtils";
import DeleteButton from "../../UI/buttons/DeleteButton/DeleteButton";
import LessonService from "../../../service/api/LessonService";

export default function LessonRow(props) {

    function deleteLesson(id) {
        LessonService.deleteById(id)
            .then(res => props.onDelete(id))
            .catch(e => console.log(e))
    }

    return (
        <tr>
            <th scope="col">{props.lesson.departmentName}</th>
            <th>{formatTimestamp(props.lesson.dateStart)}</th>
            <th>{formatTimestamp(props.lesson.dateEnd)}</th>
            <th>{props.lesson.room}</th>
            <th>{props.lesson.disciplineName}</th>
            <th>{props.lesson.groupName}</th>
            <th>{props.lesson.teacherName}</th>
            <th><DeleteButton
                btnCallback={() => deleteLesson(props.lesson.id)}
            /></th>
        </tr>
    )
}