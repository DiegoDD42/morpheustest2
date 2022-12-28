import useFetch from "../useFetch";
import { useEffect, useState } from "react";
import TabelaUsuarios from "./TabelaUsuarios";
import "./styles.css";

const Listar = () => {
  const {
    data: todosUsuarios,
    error,
    isPending,
  } = useFetch("http://localhost:8080/usuarios");
  const [nome, setNome] = useState("");
  const [usuarios, setUsuarios] = useState("");

  useEffect(() => {
    if (nome === "") {
      setUsuarios(todosUsuarios);
    }
  }, [nome, todosUsuarios]);

  const HandleSubmit = (e) => {
    e.preventDefault();
    const novosUsuarios = todosUsuarios.filter((x) => x.nome.includes(nome));
    setUsuarios(novosUsuarios);
  };

  return (
    <div className="listar">
      <header>
        <h1>Lista de Usuários</h1>
      </header>
      <form onSubmit={HandleSubmit}>
        <label>Nome do Usuário:</label>
        <input
          type="text"
          value={nome}
          onChange={(e) => setNome(e.target.value)}
        />
        <button>Procurar</button>
      </form>
      <div className="tabela">
        {error && <div>{error}</div>}
        {isPending && <div>Carregando...</div>}
        {usuarios && <TabelaUsuarios usuarios={usuarios} />}
      </div>
    </div>
  );
};

export default Listar;
