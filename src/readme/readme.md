curl localhost:2555/livro -u pantera:coticoti (OK)
[{"id":1,"nome":"sr dos anels","preco":200.0},{"id":2,"nome":"rambo","preco":20.0},{"id":3,"nome":"harry potter","preco":400.0},{"id":4,"nome":"sr dos anels","preco":200.0},{"id":5,"nome":"rambo","preco":20.0},{"id":6,"nome":"harry potter","preco":400.0}]

curl localhost:2555/livro -u coringa:password (OK)
[{"id":1,"nome":"sr dos anels","preco":200.0},{"id":2,"nome":"rambo","preco":20.0},{"id":3,"nome":"harry potter","preco":400.0},{"id":4,"nome":"sr dos anels","preco":200.0},{"id":5,"nome":"rambo","preco":20.0},{"id":6,"nome":"harry potter","preco":400.0}]


gravar no terminal:
curl -i --user coringa:password -H 'Content-Type:application/json' \
-H 'Accept:application/json' -X POST http://localhost:2555/livro \
-d '{"nome":"Tsukihime", "preco":60}'

deletar por terminal:

curl -i --user coringa:password -H 'Content-Type:application/json'-H 'Accept:application/json' -X DELETE http://localhost:2555/livro/6



Put por terminal
curl -i --user coringa:password -H 'Content-Type:application/json' -H 'Accept:application/json' -X PUT http://localhost:2555/livro/6 -d '{"nome":"Tsukihime by Nasu Kinoko", "preco":60}'




