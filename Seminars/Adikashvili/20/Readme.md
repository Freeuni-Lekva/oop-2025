```
mysql-job:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3  # Check out the code from the repo

      - name: Set up Java
        uses: actions/setup-java@v1
        with:
          java-version: '1.8'

      - name: Start MySQL container manually with Docker
        run: |
          docker run -d \
            --name test-mysql \
            -e MYSQL_ROOT_PASSWORD=root \
            -e MYSQL_DATABASE=students_db \
            -p 3306:3306 \
            mysql:8.0

      # Wait until MySQL is ready to accept connections
      - name: Wait for MySQL to be ready
        run: |
          while ! mysqladmin ping --host=127.0.0.1 --port=3306 --user=root --password=root --silent; do
            echo "Waiting for MySQL to be available..."
            sleep 5
          done

      # Run the Java code that tests the MySQL connection
      - name: Test MySQL connection from Java
        run: |
          echo "Testing database connection..."
          cd 11-12
          mvn compile exec:java -Dexec.mainClass="Main"
```