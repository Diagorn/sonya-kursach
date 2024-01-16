import React from "react";
import {formatTimestamp} from "../../../utils/DateUtils";

export default function LessonRow(props) {

    return (
        <tr>
            <th scope="col">{props.lesson.departmentName}</th>
            <th>{formatTimestamp(props.lesson.dateStart)}</th>
            <th>{formatTimestamp(props.lesson.dateEnd)}</th>
            <th>{props.lesson.room}</th>
            <th>{props.lesson.disciplineName}</th>
            <th>{props.lesson.groupName}</th>
            <th>{props.lesson.teacherName}</th>
        </tr>
    )
}