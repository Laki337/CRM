
class MyComponent extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            error: null,
            isLoaded: false,
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
    validate(){
        let input = this.state.input;

        let errors = {};
        let isValid = true;
        if (!input["name"]) {
            isValid = false;
            errors["name"] = "Please enter your name.";
        }
        if (!input["email"]) {
            isValid = false;
            errors["email"] = "Please enter your email Address.";
        }
        if (typeof input["email"] !== "undefined") {
            let pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
            if (!pattern.test(input["email"])) {
                isValid = false;
                errors["email"] = "Please enter valid email address.";
            }
        }
        if (!input["comment"]) {
            isValid = false;
            errors["comment"] = "Please enter your comment.";
        }
        this.setState({
            errors: errors
        });
        return isValid;
    }
    handleChange(event) {

        let input = this.state.input;

        input[event.target.name] = event.target.value;



        this.setState({

            input

        });
    }
    handleSelect(event) {
        this.setState({ showing: true})

            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        isLoaded: true,
                        users: result
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }

    handleSubmit(event) {
        event.preventDefault();
        if(this.validate()){
            console.log(this.state);
            let input = {};
            input["name"] = "";
            input["email"] = "";
            input["comment"] = "";
            this.setState({input:input});
            alert('Demo Form is submited');
        }


    }

    componentDidMount() {
        fetch("http://localhost:8082/get/departments")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        isLoaded: true,
                        departments: result
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )

    }

    render() {
        const {error, isLoaded, departments, users} = this.state;
        if (error) {
            return <div>Ошибка: {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Загрузка...</div>;
        } else {
            return (
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Name:</label>
                        <input
                            type="text"
                            name="name"
                            value={this.state.input.name}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter name"
                            id="name"/>
                        <div className="text-danger">{this.state.errors.name}</div>
                    </div>
                    <label className="control-label">Описание задачи</label>
                    <div className="controls">
                        <input className="input-xlarge focused" name="full_text" type="text"
                               placeholder="Описание заадчи"/>
                    </div>
                    <label className="control-label">Дата начала</label>
                    <div className="controls">
                        <input className="input-xlarge focused" name="localDateTimeStart" type="date"
                               placeholder="Дата начала"/>
                    </div>
                    <label className="control-label">Дата конца</label>
                    <div className="controls">
                        <input className="input-xlarge focused" name="localDateTimeEnd" type="date"
                               placeholder="Дата конца"/>
                    </div>
                    <div className="controls">
                        <select name="user" id="foo" onChange={this.handleSelect}>
                            <option disabled>Выберите отдел</option>
                            {departments.map(department => (

                                <option key={department.id}> {department.name}
                                </option>

                            ))}
                        </select>
                    </div>
                    { this.state.showing ?  <div className="controls hideSelect" id="hideSelect">
                            <select name="user" id="fooo">
                                <option disabled>Выберите отдел</option>
                                {users.map(user =>(

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

}

ReactDOM.render(
    <MyComponent/>
    ,
    document.getElementById('root')
);
