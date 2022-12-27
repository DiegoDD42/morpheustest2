import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Menu from './Menu';
import Listar from './Listar';
import Cadastrar from './Cadastrar';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Menu />}/>
          <Route path='/listar' element={<Listar />} />
          <Route path='/cadastrar' element={<Cadastrar />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
