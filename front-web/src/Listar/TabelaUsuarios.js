const TabelaUsuarios = ({ usuarios }) => {
  return (
    <div className="tabela-usuario">
      <table>
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
          </tr>
        </thead>
        <tbody>
          {usuarios.map((usuario) => (
            <tr key={usuario.codigo}>
              <td>{usuario.codigo}</td>
              <td>{usuario.nome}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TabelaUsuarios;
