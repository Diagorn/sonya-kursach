import React from "react";
import {formatDate} from "../../../utils/DateUtils";

export default function EmployeeJobRow(props) {

    return (
        <tr>
            <th scope="col">{props.job.id}</th>
            <th>{props.job.position}</th>
            <th>{formatDate(props.job.dateStart)}</th>
            <th>{formatDate(props.job.dateEnd)}</th>
            <th>{props.job.organizationName}</th>
            <th>{props.job.salary}</th>
            <th>{props.job.employeeFio}</th>
        </tr>
    )
}