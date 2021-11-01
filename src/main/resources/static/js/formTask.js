class Task extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            departments: [],
            users: [],
            value: '',
            showing: false,
            depo: 'Отдел1',
            input: {},
            errors: {}
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleSelect = this.handleSelect.bind(this);
    }


    handleChange(event) {
        let input = this.state.input;
        input[event.target.name] = event.target.value;
        this.setState({

            input
        });
    }

    handleSelect(event) {


        this.setState({showing: true})
        fetch("http://localhost:8082/get/users/" + this.state.depo)
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        users: result
                    });
                },
            )
    }

    handleSubmit(values) {

        values.preventDefault();


        if (this.validate()) {

            console.log(this.state);


            let input = {};

            input["name"] = "";

            input["email"] = "";

            input["comment"] = "";

            this.setState({input: input});


        }
        fetch('http://localhost:8082/get/createTaskUser',{
            body: JSON.stringify(values.target[0].value)
        } ) .then(res => res.json())


    }

    validate() {
        let input = this.state.input;

        let isValid = true;
     /*   let errors = {};


        if (!input["name"]) {
            isValid = false;
            errors["name"] = "Пожалуйста заполните это поле";
        }
        if (!input["text"]) {
            isValid = false;
            errors["text"] = "Пожалуйста заполните это поле";
        }
        if (!input["dataStart"]) {
            isValid = false;
            errors["dataStart"] = "Пожалуйста заполните это поле";
        }
        if (!input["dataEnd"]) {
            isValid = false;
            errors["dataEnd"] = "Пожалуйста заполните это поле";
        }

        /!*   if (input["name"].toString().length>0) {
               let pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
               if (!pattern.test(input["name"])) {
                   isValid = false;
                   errors["name"] = "Некорректное поле";
               }
           }*!/
        if (input["text"].toString().length < 5) {


            errors["text"] = "Некорректное поле";

        }
        if (new Date(input["dataStart"]) > new Date(input["dataEnd"])) {

            isValid = false;
            errors["dataStart"] = "Некорректное поле";

        }
        if (new Date(input["dataEnd"]) < new Date()) {

            isValid = false;
            errors["dataEnd"] = "Некорректное поле";

        }
        this.setState({
            errors: errors
        });*/
        return isValid;
    }

    componentDidMount() {
        fetch("http://localhost:8082/get/departments")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        departments: result
                    });
                },
            )
    }

    render() {
        const {departments, users} = this.state;

        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-group">
                    <label htmlFor="name">Name:</label>
                    <input
                        type="text"
                        name="name"
                        value={this.state.name}
                        onChange={this.handleChange}
                        className="form-control"
                        placeholder="Enter name"/>
                    <div className="text-danger">{this.state.errors.name}</div>
                </div>
                <label className="control-label">Описание задачи</label>
                <div className="controls">
                    <input className="input-xlarge focused" name="text" type="text" value={this.state.text}
                           onChange={this.handleChange}
                           placeholder="Описание заадчи"/>
                    <div className="text-danger">{this.state.errors.text}</div>
                </div>
                <label className="control-label">Дата начала</label>
                <div className="controls">
                    <input className="input-xlarge focused" name="dataStart" type="date" value={this.state.dataStart}
                           onChange={this.handleChange}
                           placeholder="Дата начала"/>
                    <div className="text-danger">{this.state.errors.dataStart}</div>
                </div>
                <label className="control-label">Дата конца</label>
                <div className="controls">
                    <input className="input-xlarge focused" name="dataEnd" type="date" value={this.state.dataEnd}
                           onChange={this.handleChange}
                           placeholder="Дата конца"/>
                    <div className="text-danger">{this.state.errors.dataEnd}</div>
                </div>
                <div className="controls">
                    <select name="depoSelect" id="foo" onChange={this.handleSelect}>
                        <option disabled>Выберите отдел</option>
                        {departments.map(department => (

                            <option key={department.id}> {department.name}
                            </option>

                        ))}
                    </select>

                </div>
                {this.state.showing ? <div className="controls hideSelect" id="hideSelect" name="userSelect">
                        <select name="user" id="fooo">
                            <option disabled>Выберите отдел</option>
                            {users.map(user => (

                                <option key={user.id}> {user.username}
                                </option>

                            ))}
                        </select>
                    </div>

                    : null


                }
                <button type="submit" className="btn btn-primary">Создать</button>
            </form>
        );
    }


}

ReactDOM.render(
    <Task/>
    ,
    document.getElementById('root')
);
