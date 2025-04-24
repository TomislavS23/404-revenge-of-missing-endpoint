<div align="center">
<h2 style="text-align: center;">🔥 404: Revenge of the Missing Endpoint</h2>
</div>

*"A web app that fights the horrors of broken APIs, encoding chaos, and validation despair—with extreme prejudice."*

Ever tried parsing a Chinese API without proper character support? *Yeah, it’s a nightmare.* This project is your crash
course in:

- **Brutal data validation** (XML/XSD? JSON? We *break* it so you don’t have to).
- **SOAP** (Do you want to “clean” your data? Too bad—here’s an old (WSDL) tech for you.)
- **JAXB, XML-RPC** (Like finding a VHS tape in your Netflix queue - we resurrect dead protocols (except maybe JAXB) for
  your "enjoyment").
- **Chinese API roulette** (Random products, mysterious endpoints, and *zero guarantees*).
- **Encoding wars** (Watch your terminal scream as it meets UTF-8’s evil twin GB2312.).
- **Questionable user authentication** (Authentication? Maybe. Encryption? Just enough that it looks like someone
  actually cares).

Bored? Desperate? Just like pain? **This app is your new therapist.**

---

### Languages & Frameworks

**Frontend:**

![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)

**Package Management:**

![NPM](https://img.shields.io/badge/NPM-%23CB3837.svg?style=for-the-badge&logo=npm&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

**Backend:**

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

**Database:**

![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)



<!-- GETTING STARTED -->

## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites (ArchLinux)

1. Installed Node Package Manager and Node.JS

    ```shell
    sudo pacman -S nodejs npm
    ```

2. Installed docker

    ```shell
    sudo pacman -S docker docker-buildx
    ```

3. Enable docker socket

    ```shell
    sudo systemctl enable docker.socket
    ```

4. Pull PostgreSQL image from official Docker repo

    ```shell
    docker pull postgres
    ```

### Installation

1. Configure environment variables.

> An example of required environment variables can be found in `/src/main/resources/environment` folder.

2. Clone the repo.
   ```shell
   git clone git@github.com:TomislavS23/404-revenge-of-missing-endpoint.git
   ```
3. Open `/app` folder in your favourite IDE (like Jetbrains Webstorm) and install required npm packages.
   ```shell
   npm install
   ```
4. Start your docker PSQL image.
   ```shell
   docker run --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
   ```
5. Connect to your PSQL instance and create "404rme" database by running this command in your favourite RDBMS.

   ```postgresql
   CREATE DATABASE "404rme"
   ```
6. Run the SQL script located in `/src/main/resources/database` folder.
7. Open IntelliJ IDEA and start the API.

> Access swagger interface using this link: `http://localhost:8080/swagger-ui/index.html`

8. Open your favourite editor and run the webapp.

## Usage

This project is basically just a playground to mess around with some tech – both new stuff and old things nobody uses
anymore.

You can:

- Try out whatever features are there
- Test the APIs if you feel like it
- Play with the validation stuff
- See what happens when things break (which they will)

No pressure, no fancy goals – just poke around and see what this thing does.

## Contributing

This project is under MIT licence, please read carefully what you can or can't do with this project.