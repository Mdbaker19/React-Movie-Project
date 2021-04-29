import React, {Component} from 'react';

class CreateAndViewComponent extends Component {
    render() {
        return (
            <div>
                <form>
                    <label>
                        Title for now:
                        <input type="text"/>
                    </label>
                </form>
            </div>
        );
    }
}

export default CreateAndViewComponent;