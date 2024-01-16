import React from "react";
import EditButton from "../../UI/buttons/EditButton/EditButton";
import {Link} from "react-router-dom";
import DeleteButton from "../../UI/buttons/DeleteButton/DeleteButton";
import EmployeeService from "../../../service/api/EmployeeService";
import {alertError} from "../../../utils/ExceptionUtils";
import RedirectButton from "../../UI/buttons/RedirectButton/RedirectButton";
import {formatDate} from "../../../utils/DateUtils";

export default function EmployeeRow(props) {

    function deleteEmployee() {
        EmployeeService.deleteEmployee(props.employee.id)
            .then(() => props.onDelete(props.employee.id))
            .catch(e => alertError(e))
    }

    return (
        <tr>
            <th scope="col">{props.employee.id}</th>
            <th>{props.employee.fio}</th>
            <th>{formatDate(props.employee.dateOfBirth)}</th>
            <th>{props.employee.rank}</th>
            {props.showButtons &&
                <th>
                    <div>
                        <Link to={`/employee/edit/${props.employee.id}`}>
                            <EditButton/>
                        </Link>
                    </div>
                    <div className="mt-1">
                        <DeleteButton btnCallback={deleteEmployee}/>
                    </div>
                    <div className="mt-1">
                        <Link to={`/employee/${props.employee.id}/degree`}>
                            <EditButton label={'Изменить образование'}/>
                        </Link>
                    </div>
                    <div className="mt-1">
                        <Link to={`/employee/${props.employee.id}/disciplines`}>
                            <RedirectButton label="К дисциплинам"/>
                        </Link>
                    </div>
                    <div className="mt-1">
                        <Link to={`/employee/${props.employee.id}/jobs`}>
                            <RedirectButton label="К работам"/>
                        </Link>
                    </div>
                </th>
            }
        </tr>
    )
}