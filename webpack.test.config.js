var path = require("path");
var glob = require("glob");

module.exports = {
    entry:{
        vue: glob.sync("./modules/web/site/src/test/resources/vue/**/*Test.ts"),
        TS: glob.sync("./modules/web/site/src/test/resources/ts/**/*Test.ts")
    },
    output: {
        path: path.join(__dirname, "/modules/web/site/src/test/resources/"),
        filename: "[name]/build/testBundle.js"
    },
    module: {
        loaders: [
            {
                test: /\.ts$/,
                exclude: /node_modules|vue\/src/,
                loader: "ts-loader",
                options: {
                    appendTsSuffixTo: [/\.vue$/]
                }
            },
            {
                test: /\.js$/,
                exclude: /node_modules|vue\/src/,
                loader: "babel-loader"
            },
            /**
             * Looking for .vue endings and
             * compiling them to JavaScript with vue-loader (an npm package)
             */
            {
                test: /\.vue$/,
                loader: "vue-loader",
                options: {
                }
            }
        ]
    },
    resolve: {
        extensions: [".ts", ".js", ".vue"],
        alias: {
            "vue$": "vue/dist/vue.esm.js"
        }
    }
};
